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
        Long protein,
        Long duration
) {
    public static TodayInfoResDto from(Today today) {
        return TodayInfoResDto.builder()
                .todayId(today.getTodayId())
                .userId(today.getUser().getUserId())
                .dietId(today.getDiet().getDietId())
                .exerciseId(today.getExercise().getExerciseId())
                .kcal(today.getDiet().getKcal())
                .carb(today.getDiet().getCarb())
                .fat(today.getDiet().getFat())
                .protein(today.getDiet().getProtein())
                .build();
    }

}
