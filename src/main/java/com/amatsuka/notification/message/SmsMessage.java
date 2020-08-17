package com.amatsuka.notification.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SmsMessage {
    private String phone;

    private String text;

    private ESmsRequestStatus status;

    private ESmsRequestType type;

    private Long sourceId;
}
