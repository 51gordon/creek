package com.creek.unbiz.mysql.lib.exp;

/**
 * Created by 成国栋 on 2017-04-18 00:14:00.
 */
public class InvalidMysqlDataException extends RuntimeException {
  public InvalidMysqlDataException() {
  }

  public InvalidMysqlDataException(String message) {
    super(message);
  }

  public InvalidMysqlDataException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidMysqlDataException(Throwable cause) {
    super(cause);
  }

  public InvalidMysqlDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

