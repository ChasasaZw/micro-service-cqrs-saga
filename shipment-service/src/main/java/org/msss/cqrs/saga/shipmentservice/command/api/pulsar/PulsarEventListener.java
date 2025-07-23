package org.msss.cqrs.saga.shipmentservice.command.api.pulsar;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.pulsar.client.api.*;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.io.IOException;


@Component
public class PulsarEventListener implements Closeable, Runnable {

    private final PulsarClient pulsarClient;
    private final EventBus eventBus;
    private Consumer<byte[]> consumer;
    private Thread listenerThread;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String TOPIC_NAME = "shipping-events";
    private static final String SUBSCRIPTION_NAME = "shipping-subscription";



    public PulsarEventListener(PulsarClient pulsarClient, EventBus eventBus) {
        this.pulsarClient = pulsarClient;
        this.eventBus = eventBus;
    }


    @PostConstruct
    public void start() throws PulsarClientException {
        this.consumer = pulsarClient.newConsumer(Schema.BYTES)
                .topic(TOPIC_NAME)
                .subscriptionName(SUBSCRIPTION_NAME)
                .subscribe();
        listenerThread = new Thread(this);
        listenerThread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message<byte[]> msg = consumer.receive(); // Blocking receive
                Object event = deserialize(msg.getValue());
                eventBus.publish(GenericEventMessage.asEventMessage(event));
                consumer.acknowledge(msg);
            } catch (Exception e) {
                System.err.println("Event processing error: " + e.getMessage());

            }
        }
    }


    private Object deserialize(byte[] data) {
        try {
            return objectMapper.readValue(data, Object.class);
        } catch (Exception e) {
            throw new RuntimeException("failed to deserialize event from Pulsar", e);
        }
    }

    @PreDestroy
    @Override
    public void close() throws IOException {
        if (consumer != null) {
            consumer.close();
        }


    }

}
