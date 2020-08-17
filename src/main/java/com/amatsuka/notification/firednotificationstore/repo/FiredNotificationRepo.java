package com.amatsuka.notification.firednotificationstore.repo;

import com.amatsuka.notification.ENotificationType;
import com.amatsuka.notification.firednotificationstore.domain.FiredNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiredNotificationRepo extends JpaRepository<FiredNotification, Long> {
    List<FiredNotification> findAllByTypeAndRecipientIdAndSourceId(ENotificationType type, String recipientId, String sourceId);
}
