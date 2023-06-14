package org.as.repository.model;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Notification {
    private final String content;
    private final LocalDate issueDate;
    private final List<String> emailAddresses;
    private final SendStatus sendStatus;

    public Notification(String content, LocalDate issueDate, List<String> emailAddresses, SendStatus sendStatus) {
        this.content = content;
        this.issueDate = issueDate;
        this.emailAddresses = emailAddresses;
        this.sendStatus = sendStatus;
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

    public SendStatus getSendStatus() {
        return sendStatus;
    }
}
