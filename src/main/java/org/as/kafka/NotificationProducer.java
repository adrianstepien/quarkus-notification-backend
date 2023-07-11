package org.as.kafka;

import org.as.controller.dto.NotificationDto;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificationProducer {

    private static final String TOPIC_NAME = "notification_topic";

    @Channel(TOPIC_NAME)
    Emitter<NotificationDto> emitter;

    public void produce(NotificationDto notificationDto) {
        emitter.send(notificationDto);
    }
}
