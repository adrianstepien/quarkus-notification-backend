package org.as.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.as.repository.model.Notification;
import org.as.repository.model.SendStatus;

import java.util.List;

@ApplicationScoped
public class NotificationRepository implements PanacheRepository<Notification> {

    public List<Notification> getNotifications() {
        return listAll();
    }

    public List<Notification> getReadyNotifications() {
        return list("sendStatus", SendStatus.READY);
    }

    public Notification getNotificationById(Long id) {
        return findByIdOptional(id).orElseThrow(() -> new RuntimeException("Cannot find notification with id " + id));
    }

    public void saveAll(List<Notification> notifications) {
        persist(notifications);
    }

    public void save(Notification notification) {
        persist(notification);
    }
}
