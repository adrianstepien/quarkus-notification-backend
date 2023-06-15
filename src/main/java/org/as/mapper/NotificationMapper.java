package org.as.mapper;

import org.as.controller.dto.NotificationDto;
import org.as.repository.model.Notification;
import org.as.repository.model.SendStatus;
import org.as.repository.model.TargetDetails;

import java.util.stream.Collectors;

public class NotificationMapper {

    public static NotificationDto mapEntityToDto(Notification notification) {
        return new NotificationDto(notification.getContent(),
                                    notification.getIssueDate(),
                                    notification.getTargetDetails().stream().map(TargetDetails::getEmailAddress).collect(Collectors.toSet()));
    }

    public static Notification mapDtoToEntity(NotificationDto notificationDto) {
        return new Notification(null,
                notificationDto.getContent(),
                notificationDto.getIssueDate(),
                SendStatus.NEW,
                notificationDto.getEmailAddresses().stream().map(TargetDetails::new).collect(Collectors.toSet()));
    }
}
