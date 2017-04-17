package com.creek.unbiz.mysql.lib;

/**
 * Created by 成国栋 on 2017-04-17 23:53:00.
 */
public class TransportConfig {
  private int connectTimeout = 15000;
  private int soTimeout = 15000;
  private int receiveBufferSize;
  private int sendBufferSize;
  private boolean keepAlive = true;

  public int getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(int connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public int getSoTimeout() {
    return soTimeout;
  }

  public void setSoTimeout(int soTimeout) {
    this.soTimeout = soTimeout;
  }

  public int getReceiveBufferSize() {
    return receiveBufferSize;
  }

  public void setReceiveBufferSize(int receiveBufferSize) {
    this.receiveBufferSize = receiveBufferSize;
  }

  public int getSendBufferSize() {
    return sendBufferSize;
  }

  public void setSendBufferSize(int sendBufferSize) {
    this.sendBufferSize = sendBufferSize;
  }

  public boolean isKeepAlive() {
    return keepAlive;
  }

  public void setKeepAlive(boolean keepAlive) {
    this.keepAlive = keepAlive;
  }
}
