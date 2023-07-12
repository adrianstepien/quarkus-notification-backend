package org.as.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "target_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TargetDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email_address")
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "notification_id", nullable = false)
    public Notification notification;
}
