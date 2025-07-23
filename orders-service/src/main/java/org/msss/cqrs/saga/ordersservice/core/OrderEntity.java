package org.msss.cqrs.saga.ordersservice.core;

import org.msss.cqrs.saga.ordersservice.command.api.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_table")
public class OrderEntity extends BaseEntity{

    @Id
    private String orderId;
    private String userId;
    private String productId;
    private int quantity;
    private String addressId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


}
