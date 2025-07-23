package org.msss.cqrs.saga.shipmentservice;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = {
		"org.axonframework.eventsourcing.eventstore.jpa",
		"org.msss.cqrs.saga.shipmentservice.*," + "org.axonframework.modelling.saga.repository.jpa",
		"org.axonframework.eventhandling.tokenstore.jpa"

})
public class ShipmentServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(ShipmentServiceApplication.class, args);
	}

	@Bean
	public XStream xStream() {
		XStream xStream = new XStream();
		xStream.addPermission(AnyTypePermission.ANY);
		return xStream;
	}

}
