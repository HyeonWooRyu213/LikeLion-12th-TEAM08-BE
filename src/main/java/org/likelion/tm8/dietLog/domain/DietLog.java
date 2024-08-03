package org.likelion.tm8.dietLog.domain;

import jakarta.persistence.*;
import org.likelion.tm8.diet.domain.Diet;

@Entity
public class DietLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dietLog_id")
    private Long dietLogId;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;
}
