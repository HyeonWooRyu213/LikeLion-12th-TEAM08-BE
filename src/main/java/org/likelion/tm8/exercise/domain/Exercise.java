package org.likelion.tm8.exercise.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.likelion.tm8.exercise.api.dto.request.ExerciseUpdateReqDto;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.user.domain.User;
import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDateTime;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.user.domain.User;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    // 소모 칼로리
    @Column(name = "caloriesBurned")
    private Long caloriesBurned;

    // 운동 시간
    @Column(name = "duration")
    private Long duration;

    // 운동 이름
    @Column(name = "name")
    private String name;

    // 운동 시작시간
    @Column(name = "start_time")
    private LocalDateTime startTime;

    // 운동 종료시간
    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Today> todayList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Exercise(Long exerciseId, Long caloriesBurned, Long duration, String name) {
        this.exerciseId = exerciseId;
        this.caloriesBurned = caloriesBurned;
        this.duration = duration;
        this.name = name;
    }

    public void update(ExerciseUpdateReqDto exerciseUpdateReqDto) {
        this.name = exerciseUpdateReqDto.name();
        this.caloriesBurned = exerciseUpdateReqDto.caloriesBurned();
        this.duration = exerciseUpdateReqDto.duration();
    }

    public void startSession() {
        this.startTime = LocalDateTime.now();
    }

    public void endSession() {
        this.endTime = LocalDateTime.now();
        this.duration = Duration.between(startTime, endTime).getSeconds();
    }
}
