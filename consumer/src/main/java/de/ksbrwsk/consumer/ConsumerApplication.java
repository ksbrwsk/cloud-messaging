package de.ksbrwsk.consumer;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import java.util.Map;
import java.util.logging.Logger;

@EnableBinding(ConsumerChannels.class)
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getDeclaredType().getName());
    }

    @Bean
    public IntegrationFlow integrationFlow(Logger logger, ConsumerChannels consumerChannels) {
        return IntegrationFlows
                .from(consumerChannels.producer())
                .handle(Map.class, (payload, headers) -> {
                    logger.info("new Message arrived: " + payload);
                    return null;
                })
                .get();
    }
}
