package org.as.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
