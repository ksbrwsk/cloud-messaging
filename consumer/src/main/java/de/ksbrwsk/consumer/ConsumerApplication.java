package de.ksbrwsk.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import java.util.Map;

@RefreshScope
@EnableBinding(ConsumerChannels.class)
@SpringBootApplication
@Slf4j
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    public IntegrationFlow integrationFlow(ConsumerChannels consumerChannels) {
        return IntegrationFlows
                .from(consumerChannels.producer())
                .handle(Map.class, (payload, headers) -> {
                    log.info("new Message arrived: " + payload);
                    return null;
                })
                .get();
    }
}
