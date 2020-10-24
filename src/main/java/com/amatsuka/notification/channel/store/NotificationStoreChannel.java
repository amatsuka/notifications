package com.amatsuka.notification.channel.store;

import com.amatsuka.notification.channel.ENotificationChannelType;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;

public class NotificationStoreChannel implements NotificationChannel {

    @Override
    public void send(Notification notification) {
        notification.toNotificationStore().ifPresent(message ->
                System.out.printf("Отправка через NotificationStoreChannel type: %s, text: %s \n", message.getType(), message.getText())
        );
    }

    @Override
    public ENotificationChannelType getType() {
        return ENotificationChannelType.NOTIFICATION_STORE;
    }
}
