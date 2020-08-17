package com.amatsuka.notification.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WebSocketMessage {
    private String username;
    private String channel;
    private String type;
    private String content;
}
