package org.msss.cqrs.saga.ordersservice.event.api;


import org.msss.cqrs.saga.ordersservice.command.api.OrderStatus;
import lombok.Value;

// Immutable object
@Value
public class OrderApproveEvent {

    private final String orderId;
    private final OrderStatus orderStatus = OrderStatus.APPROVED;

}
