package org.msss.cqrs.saga.shared_common.payment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPayment {

    private final String firstName;
    private final String lastName;
    private final String userId;
    private final PaymentDetails paymentDetails;

}
