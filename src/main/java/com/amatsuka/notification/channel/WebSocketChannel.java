package com.amatsuka.notification.channel;

import com.amatsuka.notification.ENotificationChannel;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketChannel implements NotificationChannel {
    private final WebSocketService webSocketService;

    @Override
    public void send(Notification notification) {
        notification.toWebSocket().ifPresent(message ->  {
            if (message.getChannel() != null) {
                webSocketService.sendToChannel(message.getChannel(), message.getType(), message.getContent());
            }

            if (message.getUsername() != null) {
                webSocketService.sendToUser(message.getUsername(), message.getType(), message.getContent());
            }
        });
    }

    @Override
    public ENotificationChannel getType() {
        return ENotificationChannel.WEBSOCKET;
    }
}
