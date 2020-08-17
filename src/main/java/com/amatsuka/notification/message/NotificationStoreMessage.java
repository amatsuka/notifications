package com.amatsuka.notification.message;

import com.amatsuka.notification.ENotificationType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class NotificationStoreMessage {
    private List<Long> userIds;

    private ENotificationType type;

    private Long sourceId;

    private String text;
}
