package org.vision.core.zen.address;

import com.google.protobuf.ByteString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.vision.api.GrpcAPI.DiversifierMessage;
import org.vision.api.GrpcAPI.IncomingViewingKeyDiversifierMessage;
import org.vision.api.GrpcAPI.IncomingViewingKeyMessage;
import org.vision.api.GrpcAPI.PaymentAddressMessage;
import org.vision.walletserver.WalletApi;

import java.util.Optional;

@Slf4j(topic = "shieldTransaction")
@AllArgsConstructor
public class IncomingViewingKey {

  @Setter
  @Getter
  public byte[] value; // 256

  public Optional<PaymentAddress> address(DiversifierT d) {
    DiversifierMessage.Builder dBuilder = DiversifierMessage.newBuilder();
    dBuilder.setD(ByteString.copyFrom(d.getData()));

    IncomingViewingKeyMessage.Builder incomingBuilder = IncomingViewingKeyMessage.newBuilder();
    incomingBuilder.setIvk(ByteString.copyFrom(value));

    IncomingViewingKeyDiversifierMessage.Builder builder = IncomingViewingKeyDiversifierMessage.newBuilder();
    builder.setD(dBuilder.build());
    builder.setIvk(incomingBuilder.build());
    Optional<PaymentAddressMessage> addressMessage = WalletApi.getZenPaymentAddress(builder.build());
    if (addressMessage.isPresent()) {
      return Optional.of(new PaymentAddress(d, addressMessage.get().getPkD().toByteArray()));
    } else {
      return Optional.empty();
    }
  }
}
