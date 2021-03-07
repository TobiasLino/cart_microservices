package com.example.eureka.mail;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @Autowired
    private MailService mailService;

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> message) {
        log.info("key: " + message.key());
        log.info("Header: " + message.headers());
        log.info("Partion: " + message.partition());
        log.info("Message: " + message.value());

        var mail = SimpleMail.builder()
                .from("<your-email>")
                .to("<your-email>")
                .text(message.value())
                .build();

        mailService.send(mail);
    }
}
