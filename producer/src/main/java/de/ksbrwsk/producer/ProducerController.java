package de.ksbrwsk.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ProducerController {

    private final MessageChannel consumer;

    public ProducerController(ProducerChannels channels) {
        this.consumer = channels.consumer();
    }

    @PostMapping("/greet/{name}")
    public void publish(@PathVariable String name) {
        String text = "Hello, " + name + "!";
        Map<String, Object> greeting = new HashMap<>();
        greeting.put("greeting", text);
        Message<Map<String, Object>> message = MessageBuilder
                .withPayload(greeting)
                .build();
        this.consumer.send(message);
        log.info("Message send: {}", greeting);
    }
}
