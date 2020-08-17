package com.amatsuka.notification.channel;

import com.amatsuka.notification.ENotificationChannel;
import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.contract.NotificationChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SmsChannel implements NotificationChannel {
    private final SmsRequestService smsRequestService;

    @Override
    public void send(Notification notification) {
        notification.toSms().ifPresent(message ->
                smsRequestService.createSmsRequestAndSend(message.getPhone(), message.getType(), message.getStatus(), message.getText(), message.getSourceId()));

    }

    @Override
    public ENotificationChannel getType() {
        return ENotificationChannel.SMS;
    }
}
