package com.amatsuka.notification.firednotificationstore.service;

import com.amatsuka.notification.contract.Notification;
import com.amatsuka.notification.firednotificationstore.domain.FiredNotification;
import com.amatsuka.notification.firednotificationstore.repo.FiredNotificationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FiredNotificationService {
    private final FiredNotificationRepo firedNotificationRepo;

    public boolean notificationIsFired(Notification notification) {
        return !firedNotificationRepo.findAllByTypeAndRecipientIdAndSourceId(notification.getType(), notification.getRecipientId(), notification.getSourceId()).isEmpty();
    }

    public void addNotification(Notification notification) {
        FiredNotification firedNotification = new FiredNotification()
                .setFiredAt(LocalDateTime.now())
                .setRecipientId(notification.getRecipientId())
                .setType(notification.getType())
                .setSourceId(notification.getSourceId());

        firedNotificationRepo.save(firedNotification);
    }
}
