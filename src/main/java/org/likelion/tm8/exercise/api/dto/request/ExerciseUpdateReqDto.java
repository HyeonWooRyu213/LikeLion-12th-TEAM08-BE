package org.likelion.tm8.exercise.api.dto.request;

public record ExerciseUpdateReqDto(
        String name,
        Long caloriesBurned,
        Long duration
) {
}
