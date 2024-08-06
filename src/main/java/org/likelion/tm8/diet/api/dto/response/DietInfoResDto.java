package org.likelion.tm8.diet.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.diet.domain.Diet;

@Builder
public record DietInfoResDto(
        Long dietId,
        Long kcal,
        Long carb,
        Long fat,
        Long protein,
        Long userId
) {
    public static DietInfoResDto from(Diet diet) {
        return DietInfoResDto.builder()
                .dietId(diet.getDietId())
                .kcal(diet.getKcal())
                .carb(diet.getCarb())
                .fat(diet.getFat())
                .protein(diet.getProtein())
                .userId(diet.getUser().getUserId())
                .build();
    }
}
