package com.creek.unbiz.mysql.lib.def;

/**
 * Created by 成国栋 on 2017-04-18 23:42:00.
 */
public enum MysqlCharset {
  latin1_swedish_ci(0x08),
  utf8_general_ci(0x21),
  binary(0x3f);

  private int code;

  MysqlCharset(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
