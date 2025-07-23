package org.msss.cqrs.saga.shared_common.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderShippedEvent {
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;
}
