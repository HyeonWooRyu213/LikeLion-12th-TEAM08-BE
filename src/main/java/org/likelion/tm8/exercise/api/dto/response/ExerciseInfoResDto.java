package org.likelion.tm8.exercise.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.exercise.domain.Exercise;

@Builder
public record ExerciseInfoResDto(
        Long exerciseId,
        String name,
        Long caloriesBurned,
        Long duration,
        Long userId
) {
    public static ExerciseInfoResDto from(Exercise exercise) {
        return ExerciseInfoResDto.builder()
                .exerciseId(exercise.getExerciseId())
                .name(exercise.getName())
                .caloriesBurned(exercise.getCaloriesBurned())
                .duration(exercise.getDuration())
                .userId(exercise.getUser().getUserId())
                .build();
    }
}
