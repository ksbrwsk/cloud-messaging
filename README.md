# cloud-messaging
---------------------------
### A simple Springboot application using Spring Cloud Stream with RabbitMQ Message Broker
### As seen on Spring Tips: Spring Cloud Stream by Josh Long
### see: [Youtube](https://youtu.be/HQ00E60kB6c)

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

or

```
cd producer
java -jar target/consumer-<VERSION>.jar
```

the consumer application

```
cd consumer
mvn spring-boot:run
```

or

```
cd consumer
java -jar consumer-<VERSION>.jar
```


create and send a message

```
curl -d{} http://localhost:8000/greet/YourName
```
