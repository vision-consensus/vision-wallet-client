package org.vision.core.zen.address;

import com.google.protobuf.ByteString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.vision.api.GrpcAPI.BytesMessage;
import org.vision.api.GrpcAPI.ExpandedSpendingKeyMessage;
import org.vision.core.exception.ZksnarkException;
import org.vision.walletserver.WalletApi;

import java.util.Optional;

@AllArgsConstructor
public class SpendingKey {

  @Setter
  @Getter
  public byte[] value;

  public ExpandedSpendingKey expandedSpendingKey() throws ZksnarkException {
    BytesMessage sk = BytesMessage.newBuilder().setValue(ByteString.copyFrom(value)).build();
    Optional<ExpandedSpendingKeyMessage> esk = WalletApi.getExpandedSpendingKey(sk);
    if (!esk.isPresent()) {
      throw new ZksnarkException("getExpandedSpendingKey failed !!!");
    } else {
      return new ExpandedSpendingKey(
          esk.get().getAsk().toByteArray(),
          esk.get().getNsk().toByteArray(),
          esk.get().getOvk().toByteArray());
    }
  }

  public FullViewingKey fullViewingKey() throws ZksnarkException {
    return expandedSpendingKey().fullViewingKey();
  }
}

