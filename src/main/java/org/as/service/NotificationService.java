package org.as.service;

import org.as.controller.dto.NotificationDto;
import org.as.mapper.NotificationMapper;
import org.as.repository.NotificationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class NotificationService {

    @Inject
    NotificationRepository notificationRepository;

    public Set<NotificationDto> getNotifications() {
        return notificationRepository.getNotifications().stream()
                .map(NotificationMapper::mapNotificationToDto)
                .collect(Collectors.toSet());
    }
}
