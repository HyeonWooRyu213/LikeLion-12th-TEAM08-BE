package org.likelion.tm8.today.application;

import lombok.RequiredArgsConstructor;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.diet.domain.repository.DietRepository;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.exercise.domain.repository.ExerciseRepository;
import org.likelion.tm8.today.api.request.TodaySaveReqDto;
import org.likelion.tm8.today.api.response.TodayInfoResDto;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.today.domain.repository.TodayRepository;
import org.likelion.tm8.user.domain.User;
import org.likelion.tm8.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TodayService {
    private final TodayRepository todayRepository;
    private final UserRepository userRepository;
    private final DietRepository dietRepository;
    private final ExerciseRepository exerciseRepository;

    @Transactional
    public void todaySave(TodaySaveReqDto todaySaveReqDto) {
        User user = userRepository.findById(todaySaveReqDto.userId())
                .orElseThrow(()-> new IllegalArgumentException("회원 없음"));

        Diet diet = dietRepository.findById(todaySaveReqDto.dietId())
                .orElseThrow(()-> new IllegalArgumentException("식단 없음"));

        Exercise exercise = exerciseRepository.findById(todaySaveReqDto.exerciseId())
                .orElseThrow(()-> new IllegalArgumentException("운동 없음"));

        Today today = Today.builder()
                .kcal(diet.getKcal())
                .carb(diet.getCarb())
                .fat(diet.getFat())
                .protein(diet.getProtein())
                .user(user)
                .exercise(exercise)
                .diet(diet)
                .build();

        todayRepository.save(today);
    }

    public List<TodayInfoResDto> todayFindAll() {
        List<Today> todays = todayRepository.findAll();
        return todays.stream()
                .map(TodayInfoResDto::from)
                .collect(Collectors.toList());
    }
}
