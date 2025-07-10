package com.org.msss.cqrs.saga.ordersservice.event.api;

import com.org.msss.cqrs.saga.ordersservice.command.api.OrderStatus;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class OrderRejectEvent {

    String orderId;
    String reason;

    private  final OrderStatus orderStatus = OrderStatus.REJECTED;

}
