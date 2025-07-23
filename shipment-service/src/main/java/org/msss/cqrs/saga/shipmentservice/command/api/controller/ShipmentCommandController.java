package org.msss.cqrs.saga.shipmentservice.command.api.controller;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.msss.cqrs.saga.shared_common.command.ShipOrderCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shipment")
@RequiredArgsConstructor
public class ShipmentCommandController {

 private final CommandGateway commandGateway;

 @PostMapping
 public String shipOrder(@RequestBody ShipOrderCommand shipOrderCommand) {
  String shipmentId = "shipment" + UUID.randomUUID();
  shipOrderCommand.setShipmentId(shipmentId);
  commandGateway.sendAndWait(shipOrderCommand);
  return "Order Shipped with ID: " + shipmentId;
 }
}
