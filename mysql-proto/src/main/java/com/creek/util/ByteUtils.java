package com.creek.util;

import com.creek.unbiz.mysql.lib.exp.InvalidMysqlDataException;
import com.creek.unbiz.mysql.lib.protocol.Position;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by 成国栋 on 2017-04-18 20:11:00.
 */
public class ByteUtils {
  public static final Charset UTF8 = Charset.forName("utf-8");

  /**
   * 读取一个字节的整数
   *
   * @param buf
   * @param pos
   * @return
   */
  public static int read1Int(byte[] buf, Position pos) {
    return leftShiftByte2Int(buf[pos.getAndForwardPos()]);
  }

  public static int read2Int(byte[] buf, Position pos) {
    int value = 0;
    value |= leftShiftByte2Int(buf[pos.getAndForwardPos()]);
    value |= leftShiftByte2Int(buf[pos.getAndForwardPos()], 8);
    return value;
  }

  public static int read4Int(byte[] buf, Position pos) {
    int value = 0;
    value |= leftShiftByte2Int(buf[pos.getAndForwardPos()]);
    value |= leftShiftByte2Int(buf[pos.getAndForwardPos()], 8);
    value |= leftShiftByte2Int(buf[pos.getAndForwardPos()], 16);
    value |= leftShiftByte2Int(buf[pos.getAndForwardPos()], 24);
    return value;
  }

  public static byte[] readFixString(byte[] buf, Position pos, int len) {
    int start = pos.getPos();
    pos.forwardPos(len);
    return Arrays.copyOfRange(buf, start, pos.getPos());
  }

  /**
   * 读取mysql的string.NUL: Strings that are terminated by a [00] byte.
   *
   * @param buf
   * @param pos
   * @return
   */
  public static String readNulString(byte[] buf, Position pos) {
    int end = -1;
    int start = pos.getPos();
    for (int i = start; i < buf.length; i++) {
      if (buf[i] == 0) {
        end = i;
        break;
      }
    }
    if (end == -1) throw new InvalidMysqlDataException();
    pos.forward2Pos(end + 1);
    return new String(Arrays.copyOfRange(buf, start, end));
  }

  public static int leftShiftByte2Int(byte byteValue) {
    return leftShiftByte2Int(byteValue, 0);
  }

  public static int leftShiftByte2Int(byte byteValue, int bitCount) {
    return (byteValue & 0xff) << bitCount;
  }

  public static byte[] write1Int(int value) {
    return writeNInt(value, 1);
  }

  public static byte[] write2Int(int value) {
    return writeNInt(value, 2);
  }

  public static byte[] write4Int(int value) {
    return writeNInt(value, 4);
  }

  public static byte[] write8Int(int value) {
    return writeNInt(value, 8);
  }

  public static byte[] writeNInt(int value, int len) {
    byte[] buf = new byte[len];
    for (int i = 0; i < len; i++) {
      buf[i] = (byte) (value >> (i * 8));
    }
    return buf;
  }

  public static byte[] writeString(String s) {
    return s.getBytes(UTF8);
  }
}
