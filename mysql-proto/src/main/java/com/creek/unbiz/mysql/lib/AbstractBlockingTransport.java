package com.creek.unbiz.mysql.lib;

import com.creek.unbiz.mysql.lib.exp.NetworkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by 成国栋 on 2017-04-17 23:49:00.
 */
public abstract class AbstractBlockingTransport implements BlockingTransport {
  protected final static Logger logger = LoggerFactory.getLogger(AbstractBlockingTransport.class);

  private String host;
  private int port;
  private String userName;
  private String password;
  private String schema;
  private TransportConfig config;
  private int maxPacketSize = 0;

  protected abstract void initTransport(String sql);

  private volatile SocketHolder socketHolder;
  private volatile boolean isOpened = false;
  private volatile boolean isOpeningPhrase = false;

  public void open() {
    // 打开socket，初始化socketHolder
    socketHolder = openSocket();
    try {
      isOpeningPhrase = true;
      // 执行握手
      doHandShake();

      // 执行握手后，对连接进行初始化
      postInitTransport();
    } finally {
      isOpeningPhrase = false;
    }
    isOpened = true;
  }

  protected void postInitTransport() {

  }

  protected void doHandShake() {

  }

  private SocketHolder openSocket() {
    Socket socket = new Socket();
    try {
      socket.connect(new InetSocketAddress(host, port), config.getConnectTimeout());
      socket.setKeepAlive(config.isKeepAlive());
      socket.setSoTimeout(config.getSoTimeout());
      if (config.getSendBufferSize() > 0) {
        socket.setSendBufferSize(config.getSendBufferSize());
      }
      if (config.getReceiveBufferSize() > 0) {
        socket.setReceiveBufferSize(config.getReceiveBufferSize());
      }
      return new SocketHolder(socket, socket.getInputStream(), socket.getOutputStream());
    } catch (IOException e) {
      String errMsg = "Connect " + host + ":" + port + " failed";
      if (logger.isErrorEnabled()) {
        logger.error(errMsg, e);
      }
      throw new NetworkException(errMsg, e);
    }
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public TransportConfig getConfig() {
    return config;
  }

  public void setConfig(TransportConfig config) {
    this.config = config;
  }
}
