package com.ouss.notificationservice.kafka;

import com.ouss.notificationservice.entites.Notification;
import com.ouss.notificationservice.repostry.NotificationRepostry;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KafkaConsumer {
    NotificationRepostry notificationRepostry;





    public KafkaConsumer(NotificationRepostry notificationRepostry) {
        this.notificationRepostry = notificationRepostry;
    }

    @KafkaListener(topics = "client",groupId = "group")
    public void consume(String message){

        notificationRepostry.save(Notification.builder().message(message).build());
    }


}
