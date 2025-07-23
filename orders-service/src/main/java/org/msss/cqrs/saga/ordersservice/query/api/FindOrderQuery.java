package org.msss.cqrs.saga.ordersservice.query.api;

import lombok.*;


@RequiredArgsConstructor
@Value
public class FindOrderQuery {
    String orderId;
}
