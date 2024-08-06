package org.likelion.tm8.exercise.api.dto.request;

public record ExerciseSaveReqDto(
        String name,
        Long caloriesBurned,
        Long duration,
        Long userId
) {
}
