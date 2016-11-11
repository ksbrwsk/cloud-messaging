# cloud-messaging
---------------------------
### A simple Springboot application using Spring Cloud Stream with RabbitMQ Message Broker

**uses:**

* [Springboot](http://projects.spring.io/spring-boot/) web, actuator, integration, stream rabbit
* [RabbitMQ](https://www.rabbitmq.com/) Message Broker

## How to build and run

### 

Assuming Java, Maven and RabbitMQ are already installed on your local machine

```
mvn clean install
```

the producer application

```
cd producer
mvn spring-boot:run
```

the consumer application

```
cd producer
mvn spring-boot:run
```
create and send a message

```
curl -d{} http://localhost:8000/greet/YourName
```
