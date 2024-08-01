package org.likelion.tm8.weight.domain;

import jakarta.persistence.*;
import org.likelion.tm8.user.domain.User;

@Entity
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weight_id")
    private Long weightId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
