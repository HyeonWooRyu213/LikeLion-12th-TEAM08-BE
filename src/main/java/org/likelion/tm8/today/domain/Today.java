package org.likelion.tm8.today.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
<<<<<<< HEAD
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.today.api.request.TodayUpdateReqDto;
import org.likelion.tm8.user.domain.User;

@Entity
@Getter
=======
import lombok.NoArgsConstructor;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.user.domain.User;

@Entity
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
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
<<<<<<< HEAD

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
        this.diet = diet;
        this.exercise = exercise;
        this.kcal = diet.getKcal();
        this.carb = diet.getCarb();
        this.fat = diet.getFat();
        this.protein = diet.getProtein();
        this.duration = exercise.getDuration();
    }

    public void update(TodayUpdateReqDto todayUpdateReqDto) {
        this.kcal = todayUpdateReqDto.kcal();
        this.carb = todayUpdateReqDto.carb();
        this.fat = todayUpdateReqDto.fat();
        this.protein = todayUpdateReqDto.Protein();
        this.duration = todayUpdateReqDto.duration();
    }

}
=======
}
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
