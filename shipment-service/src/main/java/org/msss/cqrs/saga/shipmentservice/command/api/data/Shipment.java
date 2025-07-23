package org.msss.cqrs.saga.shipmentservice.command.api.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Shipment {

    @Id
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;
}
