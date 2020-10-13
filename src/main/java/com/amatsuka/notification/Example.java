package com.amatsuka.notification;

import com.amatsuka.notification.example.channel.sms.SmsChannel;
import com.amatsuka.notification.example.channel.sms.SmsService;
import com.amatsuka.notification.example.channel.store.NotificationStoreChannel;
import com.amatsuka.notification.example.channel.store.NotificationStoreService;
import com.amatsuka.notification.example.channel.websocket.WebSocketChannel;
import com.amatsuka.notification.example.channel.websocket.WebSocketService;
import com.amatsuka.notification.example.firednotificationservice.FiredNotificationServiceSimple;

public class Example {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();

        NotificationChannelFactory notificationChannelFactory = new NotificationChannelFactory()
                .addChannel(new SmsChannel(new SmsService()))
                .addChannel(new WebSocketChannel(new WebSocketService()))
                .addChannel(new NotificationStoreChannel(new NotificationStoreService()));

        FiredNotificationServiceSimple firedNotificationService = new FiredNotificationServiceSimple();

        NotificationService notificationService = new NotificationService(firedNotificationService, notificationChannelFactory);

        notificationService.sendNotification(notificationFactory.exampleNotification());
    }
}
