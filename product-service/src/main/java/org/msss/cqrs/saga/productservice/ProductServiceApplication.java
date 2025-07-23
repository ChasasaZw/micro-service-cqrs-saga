package org.msss.cqrs.saga.productservice;

import org.msss.cqrs.saga.productservice.business.config.AxonConfigSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@Import({AxonConfigSecurity.class})
@EntityScan(basePackages = {
        "org.axonframework.eventsourcing.eventstore.jpa",
        "org.msss.cqrs.saga.productservice.*," + "org.axonframework.modelling.saga.repository.jpa",
        "org.axonframework.eventhandling.tokenstore.jpa"

})
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
