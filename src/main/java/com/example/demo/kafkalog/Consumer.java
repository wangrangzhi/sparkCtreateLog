package com.example.demo.kafkalog;

import com.example.demo.DemoApplication;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Consumer {

    private static Logger log = LoggerFactory.getLogger(Consumer.class);

    //@KafkaListener(topics = {"Test2"})
    public void listen(ConsumerRecord<?, ?> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            log.info(message.toString());


        }

    }
}