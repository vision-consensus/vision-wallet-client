package org.vision.keystore;


import org.vision.common.crypto.SignInterface;

public interface Credentials {
  SignInterface getPair();

  String getAddress();
}
