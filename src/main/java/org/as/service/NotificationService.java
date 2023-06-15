package org.as.service;

import org.as.controller.dto.NotificationDto;
import org.as.mapper.NotificationMapper;
import org.as.repository.NotificationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class NotificationService {

    @Inject
    NotificationRepository notificationRepository;

    public Set<NotificationDto> getNotifications() {
        return notificationRepository.getNotifications().stream()
                .map(NotificationMapper::mapEntityToDto)
                .collect(Collectors.toSet());
    }

    public NotificationDto getNotificationById(Long id) {
        return NotificationMapper.mapEntityToDto(notificationRepository.getNotificationById(id));
    }

    @Transactional
    public void addNotifications(List<NotificationDto> notificationDtos) {
        notificationRepository.saveAll(notificationDtos.stream()
                .map(NotificationMapper::mapDtoToEntity)
                .collect(Collectors.toList()));
    }
}
