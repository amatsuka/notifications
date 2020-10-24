package com.amatsuka.notification;

import com.amatsuka.notification.channel.ENotificationChannelType;
import com.amatsuka.notification.contract.NotificationChannel;

import java.util.HashSet;
import java.util.Set;

/**
 * Фабрика реализаций каналов отправки уведомлений
 */
public class NotificationChannelFactory {

    /**
     * Множество реализаций каналов
     */
    private final Set<NotificationChannel> channels = new HashSet<>();

    /**
     * Добавление реализации канала
     *
     * @param channel
     * @return объект фабрики для fluent вызовов
     */
    public NotificationChannelFactory addChannel(NotificationChannel channel) {

        if (channel == null) {
            throw new NullPointerException();
        }

        channels.add(channel);

        return this;
    }

    /**
     * Возвращает канал по типу. В случае если канал не найден вернет null.
     *
     * @param type Тип канала отправки
     * @return
     */
    public NotificationChannel factory(ENotificationChannelType type) {
        return channels.stream()
                .filter(__ -> __.getType().equals(type))
                .findFirst()
                .orElse(null);
    }

}
