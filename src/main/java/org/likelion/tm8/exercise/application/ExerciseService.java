package org.likelion.tm8.exercise.application;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.likelion.tm8.exercise.api.dto.request.ExerciseSaveReqDto;
import org.likelion.tm8.exercise.api.dto.request.ExerciseUpdateReqDto;
import org.likelion.tm8.exercise.api.dto.response.ExerciseInfoResDto;
import org.likelion.tm8.exercise.api.dto.response.ExerciseListResDto;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.exercise.domain.repository.ExerciseRepository;
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

    @Transactional
    public void exerciseSave(ExerciseSaveReqDto exerciseSaveReqDto) {
        Exercise exercise = Exercise.builder()
                .name(exerciseSaveReqDto.name())
                .caloriesBurned(exerciseSaveReqDto.caloriesBurned())
                .duration(exerciseSaveReqDto.duration())
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
=======
public class ExerciseService {
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
}
