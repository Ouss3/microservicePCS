package com.ouss.notificationservice;

import com.ouss.notificationservice.entites.Notification;
import com.ouss.notificationservice.repostry.NotificationRepostry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationServiceApplication {



    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }



}
