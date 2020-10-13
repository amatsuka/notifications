package com.amatsuka.notification;

import com.amatsuka.notification.example.ExampleNotification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotificationFactory {

    public ExampleNotification exampleNotification() {
        return new ExampleNotification();
    }
}
