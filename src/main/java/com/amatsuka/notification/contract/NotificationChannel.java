package com.amatsuka.notification.contract;


import com.amatsuka.notification.channel.ENotificationChannelType;

/**
 * Интерфейс катанала отправки уведомлений
 */
public interface NotificationChannel {
    /**
     * Отправка уведомления
     *
     * @param notification Объект уведомления
     */
    void send(Notification notification);

    /**
     * Возвращает тип канала
     *
     * @return ENotificationChannel
     */
    ENotificationChannelType getType();
}
