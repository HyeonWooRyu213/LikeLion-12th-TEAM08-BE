package org.likelion.tm8.diet.api.dto.request;

public record DietUpdateReqDto(
        Long kcal,
        Long carb,
        Long fat,
        Long protein
) {
}
