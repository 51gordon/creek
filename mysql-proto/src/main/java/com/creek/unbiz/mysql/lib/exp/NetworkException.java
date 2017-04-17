package com.creek.unbiz.mysql.lib.exp;

/**
 * Created by 成国栋 on 2017-04-18 00:14:00.
 */
public class NetworkException extends RuntimeException {
  public NetworkException() {
  }

  public NetworkException(String message) {
    super(message);
  }

  public NetworkException(String message, Throwable cause) {
    super(message, cause);
  }

  public NetworkException(Throwable cause) {
    super(cause);
  }

  public NetworkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

