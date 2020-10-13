package com.amatsuka.notification;

import com.amatsuka.notification.contract.NotificationChannel;

import java.util.ArrayList;
import java.util.List;

public class NotificationChannelFactory {
    private final List<NotificationChannel> channels = new ArrayList<>();

    public NotificationChannelFactory addChannel(NotificationChannel channel) {
        channels.add(channel);

        return this;
    }

    public NotificationChannel factory(ENotificationChannel type) {
        return channels.stream()
                .filter(__ -> __.getType().equals(type))
                .findFirst()
                .orElse(null);
    }

}
