package com.amatsuka.notification.contract;

import com.amatsuka.notification.ENotificationChannel;
import com.amatsuka.notification.ENotificationType;
import com.amatsuka.notification.message.NotificationStoreMessage;
import com.amatsuka.notification.message.SmsMessage;
import com.amatsuka.notification.message.WebSocketMessage;

import java.util.List;
import java.util.Optional;

public interface Notification {
    List<ENotificationChannel> via();

    ENotificationType getType();

    default Optional<SmsMessage> toSms() {return Optional.empty();}

    default Optional<WebSocketMessage> toWebSocket() {return Optional.empty();}

    default Optional<NotificationStoreMessage> toNotificationStore() {return Optional.empty();}

    boolean once();

    default String getSourceId() {return null;}

    default String getRecipientId() {return null;}
}
