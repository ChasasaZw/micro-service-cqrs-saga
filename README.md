
#  Coding convention  

- Controller:
  
   a) Domain-CommandController (POST, PUT, DELETE)
  
       e.g OrderCommandController, ProductCommandController
  
   b) Domain-QueryController (GET)
  
       e.g ProductQueryController
       

- Command: Action-Domain-Command
  
      e.g CreateOrderCommand, CreateProductCommand, UpdateProductCommand, ReserveProductCommand, DeleteProductCommand

- Model: Domain-Model
  
      e.g  OrderRestModel, ProductRestModel

- Aggregate: Domain-Aggregate
  
      e.g  ProductAggregate, OrderAggregate, PaymentAggregate, UserAggregate
  
- Event: Domain-Action-Event
  
      e.g OrderApproveEvent, OrderCreateEvent, OrderRejectEvent

- Event handler: Domain-Events-Hander
  
      e.g OrderEventsHandler, PaymentEventHandler, ProductEventHandler

- Query : Action-Domain-Query
  
      e.g FindOrderQuery, FindProductQuery, FindUserQuery

- Query Handler: Domain-QueryHandler
  
      e.g OrderQueryHandler, ProductQueryHandler

-------------------------------------------------------------------------------------
#  Technologies
- Java 17+
- Axon Framework Spring boot 
- Spring Cloud 
- Lombok
-  H2-DB 
- Axon Server 
- Pulsar

-------------------------------------------------------------------------------------
