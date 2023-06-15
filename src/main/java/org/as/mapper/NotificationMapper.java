package org.as.mapper;

import org.as.controller.dto.NotificationDto;
import org.as.repository.model.Notification;
import org.as.repository.model.SendStatus;
import org.as.repository.model.TargetDetails;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class NotificationMapper {

    public static NotificationDto mapEntityToDto(Notification notification) {
        return new NotificationDto(notification.getContent(),
                                    notification.getIssueDate(),
                                    notification.getTargetDetails().stream().map(TargetDetails::getEmailAddress).collect(Collectors.toSet()));
    }

    public static Notification mapDtoToEntity(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setContent(notificationDto.getContent());
        notification.setIssueDate(LocalDate.now());
        notification.setSendStatus(SendStatus.NEW);
        Set<TargetDetails> targetDetailsSet = notificationDto.getEmailAddresses().stream().map(email -> {
                        TargetDetails targetDetails = new TargetDetails();
                        targetDetails.setEmailAddress(email);
                        targetDetails.setNotification(notification);
                        return targetDetails;
                }).collect(Collectors.toSet());
        notification.setTargetDetails(targetDetailsSet);

        return notification;
    }
}
