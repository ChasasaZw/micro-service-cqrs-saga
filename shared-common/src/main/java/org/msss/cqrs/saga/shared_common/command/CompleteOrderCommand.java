package org.msss.cqrs.saga.shared_common.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CompleteOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
    private String orderStatus;
}
