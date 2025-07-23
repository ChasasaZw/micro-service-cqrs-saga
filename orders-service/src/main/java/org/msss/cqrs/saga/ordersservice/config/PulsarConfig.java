package org.msss.cqrs.saga.ordersservice.config;

import org.apache.pulsar.client.api.*;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.axonframework.serialization.Serializer;



@Configuration
public class PulsarConfig {

    private static final String PULSAR_SERVICE_URL = "pulsar://localhost:6650";


    @Bean
    public PulsarClient pulsarClient() throws PulsarClientException {
        return PulsarClient.builder()
                .serviceUrl(PULSAR_SERVICE_URL)
                .build();
    }

    @Bean
    public TokenStore tokenStore(EntityManagerProvider entityManagerProvider,
                                 Serializer serializer) {
        return JpaTokenStore.builder()
                .entityManagerProvider(entityManagerProvider)
                .serializer(serializer)
                .build();
    }



}
