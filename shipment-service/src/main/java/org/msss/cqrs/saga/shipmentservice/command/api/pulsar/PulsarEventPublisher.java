package org.msss.cqrs.saga.shipmentservice.command.api.pulsar;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class PulsarEventPublisher {

    private final PulsarClient pulsarClient;
    private Producer<byte[]> producer;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String TOPIC_NAME = "shipping-events";



    public PulsarEventPublisher(PulsarClient pulsarClient) {
        this.pulsarClient = pulsarClient;

    }

    @PostConstruct
    public void init() throws Exception {
        this.producer = pulsarClient.newProducer(Schema.BYTES)
                .topic(TOPIC_NAME)
                .create();
    }
    public void publish(byte[] eventPayload) {
        try {
            producer.send(eventPayload);
        } catch (Exception e) {
            throw new RuntimeException("Failed to publish event to Pulsar.", e);
        }
    }

    public void publishEvent(Object event) {
        try {
            byte[] payload = objectMapper.writeValueAsBytes(event);
            publish(payload);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize and publish event.", e);
        }
    }

    @PreDestroy
    public void close() throws IOException {
        if (producer != null) {
            producer.close();
        }
    }


}
