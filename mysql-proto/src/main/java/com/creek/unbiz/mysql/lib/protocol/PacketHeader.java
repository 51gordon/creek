package com.creek.unbiz.mysql.lib.protocol;

import com.creek.util.ByteUtils;

/**
 * 与mysql交互的数据包，有4个字节组成，前3个字节表示payload的长度，第4个字节表示sequenceId
 * Created by 成国栋 on 2017-04-18 23:02:00.
 */
public class PacketHeader implements Request {

  private int payloadLen;
  private int sequenceId;

  public PacketHeader() {
  }

  public PacketHeader(int payloadLen, int sequenceId) {
    this.payloadLen = payloadLen;
    this.sequenceId = sequenceId;
  }

  public int getPayloadLen() {
    return payloadLen;
  }

  public void setPayloadLen(int payloadLen) {
    this.payloadLen = payloadLen;
  }

  public int getSequenceId() {
    return sequenceId;
  }

  public void setSequenceId(int sequenceId) {
    this.sequenceId = sequenceId;
  }

  @Override
  public byte[] toByteArray() {
    byte[] buf = ByteUtils.write4Int(payloadLen);
    buf[3] = (byte) sequenceId;
    return buf;
  }
}
