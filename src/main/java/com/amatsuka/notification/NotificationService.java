package com.amatsuka.notification;

import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import com.amatsuka.notification.firednotificationstore.service.FiredNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final List<NotificationChannel> channelBeans;
    private final FiredNotificationService firedNotificationService;

    private Map<ENotificationChannel, NotificationChannel> channels = new HashMap<>();

    @PostConstruct
    public void init() {
        for (NotificationChannel channel : channelBeans) {
            channels.put(channel.getType(), channel);
        }
    }

    @Async
    public void sendNotification(Notification notification) {
        if (notification.once()) {
            if (firedNotificationService.notificationIsFired(notification)) return;

            firedNotificationService.addNotification(notification);
        }

        for(ENotificationChannel type : notification.via()) {
            NotificationChannel channel = channels.getOrDefault(type, null);

            if (channel != null) {
                channel.send(notification);
            }
        }


    }
}
