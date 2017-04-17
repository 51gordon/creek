package com.creek.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 成国栋 on 2017-04-18 00:18:00.
 */
public class IOUtils {
  public static void closeQuietly(Closeable closeable) {
    if (closeable != null) {
      try {
        closeable.close();
      } catch (IOException e) {
        // ignored
      }
    }
  }

  public static void closeQuietly(Socket socket) {
    closeQuietly((Closeable) socket);
  }

  public static void closeQuietly(InputStream in) {
    closeQuietly((Closeable) in);
  }

  public static void closeQuietly(OutputStream out) {
    closeQuietly((Closeable) out);
  }
}
