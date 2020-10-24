package com.amatsuka.notification.notification;

import com.amatsuka.notification.channel.ENotificationChannelType;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.message.NotificationStoreMessage;
import com.amatsuka.notification.message.SmsMessage;
import com.amatsuka.notification.message.WebSocketMessage;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class ExampleNotification implements Notification {
    @Override
    public List<ENotificationChannelType> via() {
        return asList(ENotificationChannelType.SMS, ENotificationChannelType.WEB_SOCKET, ENotificationChannelType.NOTIFICATION_STORE);
    }

    @Override
    public ENotificationType getType() {
        return ENotificationType.EXAMPLE_NOTIFICATION;
    }

    @Override
    public Optional<SmsMessage> toSms() {
        return Optional.of(new SmsMessage()
                .setPhone("+375000000000")
                .setText("some message"));
    }

    @Override
    public Optional<WebSocketMessage> toWebSocket() {
        return Optional.of(new WebSocketMessage()
                .setUsername("some user")
                .setContent("some content"));
    }

    @Override
    public Optional<NotificationStoreMessage> toNotificationStore() {
        return Optional.empty();
    }

    @Override
    public boolean once() {
        return true;
    }

    @Override
    public String getStoreHash() {
        return "some hash";
    }
}
