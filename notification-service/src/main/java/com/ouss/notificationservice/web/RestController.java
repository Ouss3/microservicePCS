package com.ouss.notificationservice.web;

import com.ouss.notificationservice.entites.Notification;
import com.ouss.notificationservice.repostry.NotificationRepostry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    NotificationRepostry notificationRepostry;

    public RestController(NotificationRepostry notificationRepostry) {
        this.notificationRepostry = notificationRepostry;
    }

    @GetMapping("/notifications")
    public List<Notification> getAll(){
        return notificationRepostry.findAll();
    }

    @PutMapping("/notifications/{id}")
    public Notification updateNotification(@PathVariable Integer id){
        Notification n = notificationRepostry.findById(id).orElseThrow(()-> new RuntimeException("Notification not found"));
        n.setSeen(true);
        return notificationRepostry.save(n);
    }
}
