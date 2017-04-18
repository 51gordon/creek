package com.creek.unbiz.mysql.lib.protocol;

import com.creek.unbiz.mysql.lib.protocol.tool.SafeByteArrayOutputStream;

/**
 * 抽象的请求
 */
public abstract class AbstractRequest implements Request {

  private int sequenceId;

  public AbstractRequest(int sequenceId) {
    this.sequenceId = sequenceId;
  }

  /**
   * 先写请求头，在写请求的payload
   */
  @Override
  public byte[] toByteArray() {
    SafeByteArrayOutputStream out = new SafeByteArrayOutputStream();
    // 填充head部分，将前4个字节先占住
    out.safeWriteInt(0);
    // 填充payload部分
    fillPayload(out);

    byte[] buf = out.toByteArray();

    PacketHeader header = new PacketHeader(buf.length, sequenceId);
    byte[] headBuf = header.toByteArray();
    System.arraycopy(headBuf, 0, buf, 0, 4);
    return buf;
  }

  public abstract void fillPayload(SafeByteArrayOutputStream out);

}
