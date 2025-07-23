package org.msss.cqrs.saga.ordersservice.model;

import org.msss.cqrs.saga.ordersservice.command.api.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderSummary {
    private String orderId;
    private OrderStatus orderStatus;
    private String message;

}
