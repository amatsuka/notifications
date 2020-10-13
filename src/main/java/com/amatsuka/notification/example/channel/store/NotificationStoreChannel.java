package com.amatsuka.notification.example.channel.store;

import com.amatsuka.notification.ENotificationChannel;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotificationStoreChannel implements NotificationChannel {
    private final NotificationStoreService notificationStoreService;

    @Override
    public void send(Notification notification) {
        notification.toNotificationStore().ifPresent(message -> {
            notificationStoreService.storeNotification(message.getType(), message.getText(), message.getUserIds(), message.getSourceId());
        });
    }

    @Override
    public ENotificationChannel getType() {
        return ENotificationChannel.NOTIFICATION_STORE;
    }
}
