package com.creek.unbiz.mysql.lib.protocol.tool;

import com.creek.util.ByteUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by 成国栋 on 2017-04-18 23:15:00.
 */
public class SafeByteArrayOutputStream extends ByteArrayOutputStream {
  public SafeByteArrayOutputStream() {
  }

  public SafeByteArrayOutputStream(int size) {
    super(size);
  }

  public void safeWrite(byte[] buf) {
    try {
      write(buf);
    } catch (IOException e) {
      // ignore
    }
  }

  public void safeWrite(int b) {
    safeWrite(ByteUtils.write4Int(b));
  }

  public void safeWrite(String s) {
    safeWrite(ByteUtils.writeString(s));
  }
}
