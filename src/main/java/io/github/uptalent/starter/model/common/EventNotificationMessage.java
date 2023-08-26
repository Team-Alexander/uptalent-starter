package io.github.uptalent.starter.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EventNotificationMessage {
    private Author from;
    private String to;
    private String message;
    private String contentLink;
}
