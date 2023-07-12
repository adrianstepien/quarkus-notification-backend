package org.as.sender;

import jakarta.inject.Inject;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import org.as.aws.SqsProducer;
import org.as.repository.model.SendStatus;
import org.as.service.NotificationService;


@ApplicationScoped
public class NotificationSender {

    @Inject
    NotificationService notificationService;

    @Inject
    SqsProducer sqsProducer;

    @Scheduled(every = "1h")
    void sendReadyNotifications() {
        notificationService.getReadyNotifications().forEach(
                notificationDto -> {
                    sqsProducer.sendMessage(notificationDto);
                    notificationService.changeState(notificationDto.getId(), SendStatus.SENT);
                }
        );
    }
}
