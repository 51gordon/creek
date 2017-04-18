package com.creek.unbiz.mysql.lib.connect;

import com.creek.unbiz.mysql.lib.def.MysqlCharset;
import com.creek.unbiz.mysql.lib.protocol.AbstractRequest;
import com.creek.unbiz.mysql.lib.protocol.tool.SafeByteArrayOutputStream;
import com.creek.util.StringUtils;

import static com.creek.unbiz.mysql.lib.def.CapabilityFlags.CLIENT_PROTOCOL_41;

/**
 * 这个response其实是一个请求，是服务端发送给客户端HandShakeV10后，客户端需要发送给服务端的
 * 支持mysql4.1以后的版本，由于4.1之前的版本已经很少用了，所以暂时不用实现老的HandshakeResponse320协议
 * Created by 成国栋 on 2017-04-18 22:46:00.
 */
public class HandshakeResponse41 extends AbstractRequest {
  public final static int DEFAULT_PACK_SIZE = 1 << 24 - 1;

  private int maxPackSize;
  private final byte[] reserved = new byte[23];
  private String userName;
  private String passwd;
  private String authData;

  public HandshakeResponse41(int sequenceId, String authData) {
    super(sequenceId);
    this.authData = authData;
//    this.maxPackSize = Math.max(maxPackSize, DEFAULT_PACK_SIZE);
  }

  @Override
  public void fillPayload(SafeByteArrayOutputStream out) {
    int capability = 0;
    capability |= CLIENT_PROTOCOL_41;

    out.safeWrite(capability);
    out.safeWrite(maxPackSize);
    out.write(MysqlCharset.utf8_general_ci.getCode());
    out.safeWrite(reserved);
    out.safeWrite(userName);
    if (StringUtils.isEmpty(passwd)) {
      out.safeWrite(0x00);
    } else {

    }

  }
}
