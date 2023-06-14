package org.as.repository;

import org.as.repository.model.Notification;
import org.as.repository.model.SendStatus;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class NotificationRepository {

    public Set<Notification> getNotifications() {
        return Set.of(new Notification("test", LocalDate.now(), List.of("email1", "email2"), SendStatus.NEW));
    }
}
