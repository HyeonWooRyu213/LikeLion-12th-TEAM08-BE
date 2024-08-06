package org.likelion.tm8.today.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.user.domain.User;


@Getter
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

    // 섭취한 영양성분
    private Long kcal;
    private Long carb;
    private Long fat;
    private Long protein;

    // 운동시간
    private Long duration;

    @Builder
    private Today(User user, Diet diet, Exercise exercise, Long kcal, Long carb, Long fat, Long protein, Long duration) {
        this.user = user;
        this.exercise = exercise;
        this.diet = diet;
        this.kcal = diet.getKcal();
        this.carb = diet.getCarb();
        this.fat = diet.getFat();
        this.protein = diet.getProtein();
        this.duration = exercise.getDuration();
    }

}

