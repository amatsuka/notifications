package com.amatsuka.notification.example.channel.sms;

import com.amatsuka.notification.ENotificationChannel;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SmsChannel implements NotificationChannel {
    private final SmsService smsService;

    @Override
    public void send(Notification notification) {
        notification.toSms().ifPresent(message ->
                smsService.send(message.getPhone(), message.getText())
        );

    }

    @Override
    public ENotificationChannel getType() {
        return ENotificationChannel.SMS;
    }
}
