package org.likelion.tm8.today.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.user.domain.User;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Today {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long todayId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
}
