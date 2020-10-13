package com.amatsuka.notification.contract;

public interface FiredNotificationService {
    boolean notificationIsFired(Notification notification);
    void addNotification(Notification notification);
}
