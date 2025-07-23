package org.msss.cqrs.saga.paymentservice;

import org.msss.cqrs.saga.paymentservice.config.AxonConfigSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfigSecurity.class})
@EntityScan(basePackages = {
        "org.axonframework.eventsourcing.eventstore.jpa",
        "org.msss.cqrs.saga.paymentservice.*," + "org.axonframework.modelling.saga.repository.jpa",
        "org.axonframework.eventhandling.tokenstore.jpa"

})
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

}
