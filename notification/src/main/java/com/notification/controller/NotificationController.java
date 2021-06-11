package com.notification.controller;

import com.notification.model.Message;
import com.notification.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NotificationController {
    @Autowired
    private NotifyService notifyService;

    @PostMapping("notify")
    public ResponseEntity<String> notifyEvent(@RequestBody Message message) {
        notifyService.sendMsg(message);
        return new ResponseEntity<>("Message processed successfully", HttpStatus.OK);
    }
}
