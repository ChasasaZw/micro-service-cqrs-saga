package org.msss.cqrs.saga.shipmentservice.command.api.pulsar;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore;
import org.axonframework.serialization.Serializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



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
