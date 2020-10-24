package com.amatsuka.notification.firednotificationservice;

import com.amatsuka.notification.notification.ENotificationType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class FiredNotification {
    private ENotificationType type;
    private LocalDateTime firedAt;
    private String hash;
}
