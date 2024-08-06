package org.likelion.tm8.exercise.application;

import lombok.RequiredArgsConstructor;
import org.likelion.tm8.exercise.api.dto.request.ExerciseSaveReqDto;
import org.likelion.tm8.exercise.api.dto.request.ExerciseUpdateReqDto;
import org.likelion.tm8.exercise.api.dto.response.ExerciseInfoResDto;
import org.likelion.tm8.exercise.api.dto.response.ExerciseListResDto;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.exercise.domain.repository.ExerciseRepository;
import org.likelion.tm8.user.domain.User;
import org.likelion.tm8.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;

    @Transactional
    public void exerciseSave(ExerciseSaveReqDto exerciseSaveReqDto) {
        User user = userRepository.findById(exerciseSaveReqDto.userId())
                .orElseThrow(()-> new IllegalArgumentException("회원 없음"));

        Exercise exercise = Exercise.builder()
                .name(exerciseSaveReqDto.name())
                .caloriesBurned(exerciseSaveReqDto.caloriesBurned())
                .duration(exerciseSaveReqDto.duration())
                .user(user)
                .build();

        exerciseRepository.save(exercise);
    }

    public List<ExerciseInfoResDto> exerciseFindAll() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises.stream()
                .map(ExerciseInfoResDto::from)
                .collect(Collectors.toList());
    }

    public ExerciseInfoResDto exerciseFindOne(Long exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(()-> new IllegalArgumentException("운동없음"));

        return ExerciseInfoResDto.from(exercise);
    }

    @Transactional
    public void exerciseUpdate(Long exerciseId, ExerciseUpdateReqDto exerciseUpdateReqDto) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(()-> new IllegalArgumentException("운동없음"));

        exercise.update(exerciseUpdateReqDto);
    }

    @Transactional
    public void exerciseDelete(Long exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(()-> new IllegalArgumentException("운동없음"));


    }
}
