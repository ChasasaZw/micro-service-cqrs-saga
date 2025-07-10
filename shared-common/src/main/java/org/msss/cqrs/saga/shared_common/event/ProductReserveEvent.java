package org.msss.cqrs.saga.shared_common.event;

import lombok.Data;

@Data
public class ProductReserveEvent {
    private String productId;
    private int quantity;
    private String orderId;
    private String userId;
}

