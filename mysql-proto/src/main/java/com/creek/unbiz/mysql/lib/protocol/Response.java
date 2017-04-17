package com.creek.unbiz.mysql.lib.protocol;

/**
 * Created by 成国栋 on 2017-04-18 00:28:00.
 */
public interface Response {

  void parse(byte[] buf);

  void parse(byte[] buf, Position pos);
}
