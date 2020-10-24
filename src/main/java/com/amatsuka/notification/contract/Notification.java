package com.amatsuka.notification.contract;

import com.amatsuka.notification.channel.ENotificationChannelType;
import com.amatsuka.notification.notification.ENotificationType;
import com.amatsuka.notification.message.NotificationStoreMessage;
import com.amatsuka.notification.message.SmsMessage;
import com.amatsuka.notification.message.WebSocketMessage;

import java.util.List;
import java.util.Optional;

/**
 *  Интерфейс объекта уведомления
 */
public interface Notification {
    /**
     * Возвращает список поддерживаемых каналов отправки уведомления
     *
     * @return List<ENotificationChannel>
     */
    List<ENotificationChannelType> via();

    /**
     * Возвращает тип уведомления
     *
     * @return ENotificationType
     */
    ENotificationType getType();

    /**
     * Возвращает признак того что уведомление должно отправляться только 1 раз
     *
     * @return boolean
     */
    boolean once();

    default String getStoreHash() {return "";}

    /**
     * Методы для формрирования объектов уведомлений для конкретных каналов отправки
     */

    default Optional<SmsMessage> toSms() {return Optional.empty();}

    default Optional<WebSocketMessage> toWebSocket() {return Optional.empty();}

    default Optional<NotificationStoreMessage> toNotificationStore() {return Optional.empty();}
}
