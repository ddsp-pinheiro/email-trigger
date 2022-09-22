package com.emailtrigger.listener;

import com.emailtrigger.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private final EmailService service;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "group_id")
    public void consumer(String email) throws IOException{
        service.sendEmail(email);
        logger.info(String.format("### -> Send email to: -> %s", email));
    }
}
