package com.amatsuka.notification.contract;


import com.amatsuka.notification.ENotificationChannel;

public interface NotificationChannel {
    void send(Notification notification);
    ENotificationChannel getType();
}
