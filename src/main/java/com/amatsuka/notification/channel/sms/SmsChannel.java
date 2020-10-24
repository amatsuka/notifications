package com.amatsuka.notification.channel.sms;

import com.amatsuka.notification.channel.ENotificationChannelType;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;

public class SmsChannel implements NotificationChannel {

    @Override
    public void send(Notification notification) {
        notification.toSms().ifPresent(message ->
                System.out.printf("Отправка через SmsChannel phone: %s, text: %s \n", message.getPhone(), message.getText())
        );

    }

    @Override
    public ENotificationChannelType getType() {
        return ENotificationChannelType.SMS;
    }
}
