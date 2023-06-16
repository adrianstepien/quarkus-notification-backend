package org.as.kafka;

import javax.enterprise.context.ApplicationScoped;

import org.as.controller.dto.NotificationDto;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class NotificationProducer {

    private static final String TOPIC_NAME = "notification_topic";

    //TODO: czy da się tu zmienną z propertiesów?
    @Channel(TOPIC_NAME)
    Emitter<NotificationDto> emitter;

    public void produce(NotificationDto notificationDto) {
        emitter.send(notificationDto);
    }
}
