package com.amatsuka.notification.firednotificationstore.domain;

import com.amatsuka.notification.ENotificationType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class FiredNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "firednotificationseq")
    @SequenceGenerator(name = "firednotificationseq", sequenceName = "fired_notification_id_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ENotificationType type;

    private LocalDateTime firedAt;

    private String sourceId;

    private String recipientId;
}
