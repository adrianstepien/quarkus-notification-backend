package org.as.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.as.repository.model.Notification;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class NotificationRepository implements PanacheRepository<Notification> {

    public List<Notification> getNotifications() {
        return listAll();
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
