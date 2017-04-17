package com.creek.unbiz.mysql.lib;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 成国栋 on 2017-04-17 23:49:00.
 */
public class SocketHolder {
  private final Socket socket;
  private final InputStream in;
  private final OutputStream out;

  public SocketHolder(Socket socket, InputStream in, OutputStream out) {
    this.socket = socket;
    this.in = in;
    this.out = out;
  }

  public Socket getSocket() {
    return socket;
  }

  public InputStream getIn() {
    return in;
  }

  public OutputStream getOut() {
    return out;
  }
}
