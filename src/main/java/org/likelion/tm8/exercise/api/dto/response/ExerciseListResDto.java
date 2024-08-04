package org.likelion.tm8.exercise.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.user.domain.User;

import java.util.List;

@Builder
public record ExerciseListResDto(
        List<ExerciseInfoResDto> exercises
) {
    public static ExerciseListResDto from(List<ExerciseInfoResDto> excercises) {
        return ExerciseListResDto.builder()
                .exercises(excercises)
                .build();
    }
}

