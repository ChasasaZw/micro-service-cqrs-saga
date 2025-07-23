package org.msss.cqrs.saga.ordersservice;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.config.Configuration;
import org.axonframework.config.ConfigurationScopeAwareProvider;
import org.axonframework.deadline.DeadlineManager;
import org.axonframework.deadline.SimpleDeadlineManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = {
        "org.axonframework.eventsourcing.eventstore.jpa",
        "org.msss.cqrs.saga.ordersservice.*," + "org.axonframework.modelling.saga.repository.jpa",
        "org.axonframework.eventhandling.tokenstore.jpa"

})
public class OrdersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersServiceApplication.class, args);
    }

    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY);
        return xStream;
    }

    @Bean
    @Autowired
    public DeadlineManager configDeadlineManager (Configuration config, TransactionManager transactionManager){
        return SimpleDeadlineManager.builder()
                .scopeAwareProvider(new ConfigurationScopeAwareProvider(config))
                .transactionManager(transactionManager)
                .build();
    }

}
