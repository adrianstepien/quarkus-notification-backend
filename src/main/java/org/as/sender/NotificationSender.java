package org.as.sender;

import io.quarkus.scheduler.Scheduled;
import org.as.kafka.NotificationProducer;
import org.as.repository.model.SendStatus;
import org.as.service.NotificationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NotificationSender {

    @Inject
    NotificationProducer notificationProducer;

    @Inject
    NotificationService notificationService;

    @Scheduled(every = "1h")
    void sendReadyNotifications() {
        notificationService.getReadyNotifications().forEach(
                notificationDto -> {
                    notificationProducer.produce(notificationDto);
                    notificationService.changeState(notificationDto.getId(), SendStatus.SENT);
                }
        );
    }
}
