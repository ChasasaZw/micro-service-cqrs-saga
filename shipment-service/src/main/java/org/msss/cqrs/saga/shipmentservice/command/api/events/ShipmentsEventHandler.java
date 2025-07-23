package org.msss.cqrs.saga.shipmentservice.command.api.events;

import org.msss.cqrs.saga.shared_common.event.OrderShippedEvent;
import org.msss.cqrs.saga.shipmentservice.command.api.data.Shipment;
import org.msss.cqrs.saga.shipmentservice.command.api.data.ShipmentRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("shipment-group")
public class ShipmentsEventHandler {

    private final ShipmentRepository shipmentRepository;

    public ShipmentsEventHandler(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @EventHandler
    public void on(OrderShippedEvent event) {
        Shipment shipment
                = new Shipment();
        BeanUtils.copyProperties(event,shipment);
        shipmentRepository.save(shipment);
    }
}
