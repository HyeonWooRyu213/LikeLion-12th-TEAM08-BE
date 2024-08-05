package org.likelion.tm8.today.api.response;

import lombok.Builder;
import org.likelion.tm8.today.domain.Today;

@Builder
public record TodayInfoResDto(
        Long todayId,
        Long userId,
        Long dietId,
        Long exerciseId,
        Long kcal,
        Long carb,
        Long fat,
        Long Protein,
        Long duration
) {
    public static TodayInfoResDto from(Today today) {
        return TodayInfoResDto.builder()
                .todayId(today.getTodayId())
                .userId(today.getUser().getId())
                .dietId(today.getDiet().getDietId())
                .exerciseId(today.getExercise().getExerciseId())
                .build();
    }

}
