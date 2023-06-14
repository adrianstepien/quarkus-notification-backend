package org.as.controller.dto;

import java.time.LocalDate;
import java.util.List;

public class NotificationDto {
    private final String content;
    private final LocalDate issueDate;
    private final List<String> emailAddresses;

    public NotificationDto(String content, LocalDate issueDate, List<String> emailAddresses) {
        this.content = content;
        this.issueDate = issueDate;
        this.emailAddresses = emailAddresses;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }
}
