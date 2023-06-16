package org.as.kafka;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class NotificationProducer {

    private static final String TOPIC_NAME = "notification_topic";

    //TODO: czy da się tu zmienną z propertiesów?
    @Channel(TOPIC_NAME)
    Emitter<String> emitter;

    public void produce(String message) {
        emitter.send(message);
    }
}
