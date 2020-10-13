package com.amatsuka.notification.example.firednotificationservice;

import com.amatsuka.notification.contract.FiredNotificationService;
import com.amatsuka.notification.contract.Notification;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FiredNotificationServiceSimple implements FiredNotificationService {

    private final List<FiredNotification> firedNotifications = new ArrayList<>();

    public boolean notificationIsFired(Notification notification) {
        return firedNotifications.stream()
                .noneMatch(__ -> __.getType() == notification.getType() && __.getHash().equals(notification.getHash()));
    }

    public void addNotification(Notification notification) {
        FiredNotification firedNotification = new FiredNotification()
                .setFiredAt(LocalDateTime.now())
                .setHash(notification.getHash())
                .setType(notification.getType());

        firedNotifications.add(firedNotification);
    }
}
