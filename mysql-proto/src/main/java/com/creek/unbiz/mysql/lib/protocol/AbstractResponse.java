package com.creek.unbiz.mysql.lib.protocol;

/**
 * Created by 成国栋 on 2017-04-18 20:01:00.
 */
public abstract class AbstractResponse implements Response {

  @Override
  public void parse(byte[] buf, Position pos) {
    throw new UnsupportedOperationException();
  }
}
