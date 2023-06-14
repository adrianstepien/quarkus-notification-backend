package org.as.mapper;

import org.as.controller.dto.NotificationDto;
import org.as.repository.model.Notification;

public class NotificationMapper {

    public static NotificationDto mapNotificationToDto(Notification notification) {
        return new NotificationDto(notification.getContent(),
                                    notification.getIssueDate(),
                                    notification.getEmailAddresses());
    }
}
