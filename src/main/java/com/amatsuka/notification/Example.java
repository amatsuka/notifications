package com.amatsuka.notification;

import com.amatsuka.notification.channel.sms.SmsChannel;
import com.amatsuka.notification.channel.store.NotificationStoreChannel;
import com.amatsuka.notification.channel.websocket.WebSocketChannel;
import com.amatsuka.notification.firednotificationservice.FiredNotificationServiceSimple;

public class Example {
    public static void main(String[] args) {

        /*
            Конфигурация фабрики сервисов реализующих каналы отправки уведомлений
         */
        NotificationChannelFactory notificationChannelFactory = new NotificationChannelFactory()
                .addChannel(new SmsChannel())
                .addChannel(new WebSocketChannel())
                .addChannel(new NotificationStoreChannel());

        /*
            Конфигурация сервиса регистрации отправленных уведомлений
         */
        FiredNotificationServiceSimple firedNotificationService = new FiredNotificationServiceSimple();



        NotificationService notificationService = new NotificationService(firedNotificationService, notificationChannelFactory);

        NotificationFactory notificationFactory = new NotificationFactory();

        /*
          Отправка уведомления
         */

        System.out.println("Попытка отправки уведомления");
        notificationService.sendNotification(notificationFactory.exampleNotification());

        /*
          Повторная отправка уведомления не произойдет если Notification.once() вернет true
         */
        System.out.println("Повторная попытка отправки одноразового уведомления");
        notificationService.sendNotification(notificationFactory.exampleNotification());
    }
}
