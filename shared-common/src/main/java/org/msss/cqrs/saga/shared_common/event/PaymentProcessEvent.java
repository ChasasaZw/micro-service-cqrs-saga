package org.msss.cqrs.saga.shared_common.event;


import lombok.Value;


@Value
public class PaymentProcessEvent {

    private final String orderId;
    private final String paymentId;


}
