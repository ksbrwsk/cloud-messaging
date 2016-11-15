package de.ksbrwsk.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

interface ConsumerChannels {

    @Input
    SubscribableChannel producer();
}
