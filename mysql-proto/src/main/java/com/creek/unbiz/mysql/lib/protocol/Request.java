package com.creek.unbiz.mysql.lib.protocol;

/**
 * 与mysql交互的请求，该请求对象包含请求头和请求主体数据
 * Created by 成国栋 on 2017-04-17 23:41:00.
 */
public interface Request {

  /**
   * 把请求对象转换为可以socket发送的byte数组
   *
   * @return
   */
  byte[] toByteArray();
}
