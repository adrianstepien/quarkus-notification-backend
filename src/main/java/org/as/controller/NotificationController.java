package org.as.controller;

import org.as.controller.dto.NotificationDto;
import org.as.service.NotificationService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("/notifications")
@Consumes(MediaType.APPLICATION_JSON)
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

    @GET
    @Path("{id}")
    public NotificationDto getNotificationById(@PathParam("id") Long id) {
        LOGGER.info("Get notification by id: {}", id);
        return notificationService.getNotificationById(id);
    }

    @POST
    public Response addNotifications(@RequestBody List<NotificationDto> notificationDtos) {
        LOGGER.info("Add {} notifications", notificationDtos.size());
        notificationService.addNotifications(notificationDtos);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response updateNotification(@RequestBody NotificationDto notificationDto, @PathParam("id") Long id) {
        LOGGER.info("Update notifications {}", notificationDto);
        notificationService.updateNotification(notificationDto, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteNotification(@PathParam("id") Long id) {
        LOGGER.info("Delete notification with id {}", id);
        notificationService.deleteNotification(id);
        return Response.noContent().build();
    }
}