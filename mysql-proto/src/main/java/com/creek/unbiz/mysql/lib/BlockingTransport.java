package com.creek.unbiz.mysql.lib;

import com.creek.unbiz.mysql.lib.protocol.Request;

/**
 * 描述blocking模型的mysql连接，它是一个客户端和服务器之间连接的抽象，非线程安全
 * 为了和jdbc的connection区别，这里用Transport进行命名
 * Created by 成国栋 on 2017-04-17 23:37:00.
 */
public interface BlockingTransport {

  /**
   * 打开连接
   */
  void open();

  /**
   * 关闭连接
   */
  void close();

  boolean isOpen();

  /**
   * mysql ping server，验证mysql是否存活
   * @return
   */
  boolean ping();

  /**
   * 发送请求
   *
   * @param request
   */
  void writeRequest(Request request);

  /**
   * 从连接中读取一个有效的数据块，有效的响应数据块指的是不包含包头的响应数据。本方法执行两个步骤：
   * <ul>
   * <li>读取包头，解析有效数据块的长度</li>
   * <li>读取指定长度的数据块</li>
   * <ul/>
   *
   * @return
   */
  byte[] readResponsePayload();
}
