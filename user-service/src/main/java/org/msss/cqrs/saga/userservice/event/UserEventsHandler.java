package org.msss.cqrs.saga.userservice.event;

import org.axonframework.queryhandling.QueryHandler;
import org.msss.cqrs.saga.shared_common.payment.PaymentDetails;
import org.msss.cqrs.saga.shared_common.payment.UserPayment;
import org.msss.cqrs.saga.shared_common.query.FetchUserPaymentDetailsQuery;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {


    @QueryHandler
    public UserPayment queryPayment(FetchUserPaymentDetailsQuery fetchQuery) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("Tinashe")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return UserPayment.builder()
                .firstName("Tinashe")
                .lastName("Chasasa")
                .userId(fetchQuery.getUserId())
                .paymentDetails(paymentDetails)
                .build();
    }

}
