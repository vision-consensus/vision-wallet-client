package org.vision.common.crypto;

public interface SignatureInterface {
    boolean validateComponents();

    byte[] toByteArray();
}