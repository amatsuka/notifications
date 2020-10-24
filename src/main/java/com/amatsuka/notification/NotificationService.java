package com.amatsuka.notification;

import com.amatsuka.notification.channel.ENotificationChannelType;
import com.amatsuka.notification.contract.FiredNotificationService;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;

/**
 * Сервис отправки уведомлений.
 */
@RequiredArgsConstructor
public class NotificationService {
    /**
     * Реализация сервиса регистрации отправленных уведомлений
     */
    private final FiredNotificationService firedNotificationService;

    /**
     * Фабрика реализаций каналов отправки уведомлений
     */
    private final NotificationChannelFactory notificationChannelFactory;

    /**
     * Отправляет уведомления в сконфигурированне каналы
     *
     * @param notification
     */
    public void sendNotification(Notification notification) {
        if (notification.once()) {
            if (firedNotificationService.notificationIsFired(notification)) return;

            firedNotificationService.addNotification(notification);
        }

        for(ENotificationChannelType type : notification.via()) {
            NotificationChannel channel = notificationChannelFactory.factory(type);

            if (channel != null) {
                channel.send(notification);
            }
        }
    }
}
