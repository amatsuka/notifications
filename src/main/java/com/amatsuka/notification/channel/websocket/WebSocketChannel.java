package com.amatsuka.notification.channel.websocket;

import com.amatsuka.notification.channel.ENotificationChannelType;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;

public class WebSocketChannel implements NotificationChannel {

    @Override
    public void send(Notification notification) {
        notification.toWebSocket().ifPresent(message ->  {
            if (message.getChannel() != null) {
                System.out.printf("Отправка через WebSocketChannel channel: %s, content: %s \n", message.getChannel(), message.getContent());

            }

            if (message.getUsername() != null) {
                System.out.printf("Отправка через WebSocketChannel username: %s, content: %s \n", message.getUsername(), message.getContent());
            }
        });
    }

    @Override
    public ENotificationChannelType getType() {
        return ENotificationChannelType.WEB_SOCKET;
    }
}
