package com.creek.unbiz.mysql.lib.connect;

import com.creek.unbiz.mysql.lib.def.CapabilityFlags;
import com.creek.unbiz.mysql.lib.protocol.AbstractResponse;
import com.creek.unbiz.mysql.lib.protocol.Position;

import static com.creek.util.ByteUtils.*;

/**
 * Created by 成国栋 on 2017-04-18 00:27:00.
 */
public class HandshakeV10 extends AbstractResponse {
  private int protocolVersion;
  private String serverVersion;
  private int connectionId;
  private byte[] authPart1;
  private int filter;
  private int capabilityLow;

  private int charset;
  private int status;

  private int capabilityHigh;

  private int authDataLen;

  /**
   * 保留的，目前没发现有什么用
   */
  private byte[] reserved;

  private byte[] authPart2;
  private String authPluginName;

  private int capability;

  public void parse(byte[] buf) {
    Position pos = Position.factory();
    this.protocolVersion = read1Int(buf, pos);
    this.serverVersion = readNulString(buf, pos);
    this.connectionId = read4Int(buf, pos);
    this.authPart1 = readFixString(buf, pos, 8);
    this.filter = read1Int(buf, pos);
    this.capabilityLow = read2Int(buf, pos);
    if (buf.length == pos.getPos()) {
      return;
    }
    this.charset = read1Int(buf, pos);
    this.status = read2Int(buf, pos);

    this.capabilityHigh = read2Int(buf, pos);
    this.capability = capabilityHigh << 16 | capabilityLow;

    int len = read1Int(buf, pos);

    boolean needAuth = hasCapability(CapabilityFlags.CLIENT_PLUGIN_AUTH);
    authDataLen = needAuth ? len : 0;
    reserved = readFixString(buf, pos, 10);

    boolean secureConn = hasCapability(CapabilityFlags.CLIENT_SECURE_CONNECTION);
    if (secureConn) {
      len = Math.max(13, authDataLen - 8);
      authPart2 = readFixString(buf, pos, len);
    }
    if (needAuth) {
      // hiriver上说这里可能涉及到Bug#59453
      authPluginName = readNulString(buf, pos);
    }
  }

  public boolean hasCapability(int cap) {
    return (capability & cap) == 0;
  }

  public int getProtocolVersion() {
    return protocolVersion;
  }

  public String getServerVersion() {
    return serverVersion;
  }

  public int getConnectionId() {
    return connectionId;
  }

  public byte[] getAuthPart1() {
    return authPart1;
  }

  public int getFilter() {
    return filter;
  }

  public int getCapabilityLow() {
    return capabilityLow;
  }

  public int getCharset() {
    return charset;
  }

  public int getStatus() {
    return status;
  }

  public int getCapabilityHigh() {
    return capabilityHigh;
  }

  public int getAuthDataLen() {
    return authDataLen;
  }

  public byte[] getReserved() {
    return reserved;
  }

  public byte[] getAuthPart2() {
    return authPart2;
  }

  public String getAuthPluginName() {
    return authPluginName;
  }

  public int getCapability() {
    return capability;
  }
}
