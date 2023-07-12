package org.as.aws;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.as.controller.dto.NotificationDto;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.services.sqs.SqsClient;

@ApplicationScoped
public class SqsProducer {

    @Inject
    SqsClient sqs;

    @ConfigProperty(name = "queue.url")
    String queueUrl;

    static ObjectWriter QUARK_WRITER = new ObjectMapper().writerFor(NotificationDto.class);

    public void sendMessage(NotificationDto notificationDto) {
        try {
            String message = QUARK_WRITER.writeValueAsString(notificationDto);
            sqs.sendMessage(m -> m.queueUrl(queueUrl).messageBody(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
