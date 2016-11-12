package de.ksbrwsk.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

interface ProducerChannels {

    @Output
    MessageChannel consumer();
}
