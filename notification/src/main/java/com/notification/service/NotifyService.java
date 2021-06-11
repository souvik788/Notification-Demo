package com.notification.service;

import com.notification.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public final String TOPIC = "notification-events";

    public void sendMsg(Message msg) {
        kafkaTemplate.send(TOPIC, msg);
    }
}
