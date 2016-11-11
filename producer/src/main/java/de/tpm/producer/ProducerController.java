package de.tpm.producer;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final MessageChannel consumer;

    public ProducerController(ProducerChannels channels) {
        this.consumer = channels.consumer();
    }

    @PostMapping("/greet/{name}")
    public void publish(@PathVariable String name) {
        String greeting = "Hello, " + name + "!";
        Message<String> message = MessageBuilder
                .withPayload(greeting)
                .build();
        this.consumer.send(message);
        System.out.println("Message send: " + greeting);
    }

}
