package org.msss.cqrs.saga.shared_common.command;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@Value
public class RejectOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;

    private final String reason;
}
