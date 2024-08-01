package org.likelion.tm8.exercise.domain;

import jakarta.persistence.*;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.user.domain.User;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Today> todayList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
