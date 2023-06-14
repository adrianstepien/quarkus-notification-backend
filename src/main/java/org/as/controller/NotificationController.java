package org.as.controller;

import org.as.controller.dto.NotificationDto;
import org.as.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/notifications")
@Produces(MediaType.APPLICATION_JSON)
public class NotificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);

    @Inject
    NotificationService notificationService;

    @GET
    public Set<NotificationDto> getNotifications() {
        LOGGER.info("Get notifications");
        return notificationService.getNotifications();
    }
}