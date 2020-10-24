package com.amatsuka.notification;

import com.amatsuka.notification.notification.ExampleNotification;
import lombok.RequiredArgsConstructor;

/**
 * Класс-помощник для создания уведомлений. Обычно он является сервисом и инжектит в себя другие сервисы
 * как зависимости и при создании объекта уведомлнения передает их в конструктор.
 */
@RequiredArgsConstructor
public class NotificationFactory {

    public ExampleNotification exampleNotification() {
        return new ExampleNotification();
    }
}
