package com.amatsuka.notification;

import com.amatsuka.notification.contract.FiredNotificationService;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotificationService {
    private final FiredNotificationService firedNotificationService;
    private final NotificationChannelFactory notificationChannelFactory;

    public void sendNotification(Notification notification) {
        if (notification.once()) {
            if (firedNotificationService.notificationIsFired(notification)) return;

            firedNotificationService.addNotification(notification);
        }

        for(ENotificationChannel type : notification.via()) {
            NotificationChannel channel = notificationChannelFactory.factory(type);

            if (channel != null) {
                channel.send(notification);
            }
        }


    }
}
