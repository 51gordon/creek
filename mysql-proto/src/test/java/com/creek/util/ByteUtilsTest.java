package com.creek.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 成国栋 on 2017-04-18 21:12:00.
 */
public class ByteUtilsTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void read1Int() throws Exception {

  }

  @Test
  public void leftShiftByte2Int() throws Exception {
    System.out.println(0xff);
    System.out.println(ByteUtils.yu((byte) -2));
    System.out.println(ByteUtils.yu((byte) -1));
    System.out.println(ByteUtils.yu((byte) 0));
    System.out.println(ByteUtils.yu((byte) 1));
    System.out.println(ByteUtils.yu((byte) 2));

    System.out.println(ByteUtils.leftShiftByte2Int((byte) -2));
    System.out.println(ByteUtils.leftShiftByte2Int((byte) -1));
    System.out.println(ByteUtils.leftShiftByte2Int((byte) 0));
    System.out.println(ByteUtils.leftShiftByte2Int((byte) 1));
    System.out.println(ByteUtils.leftShiftByte2Int((byte) 2));
  }

}
