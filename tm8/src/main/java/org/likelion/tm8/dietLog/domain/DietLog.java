package org.likelion.tm8.dietLog.domain;

import jakarta.persistence.*;

@Entity
public class DietLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dietLog_id")
    private Long id;
}
