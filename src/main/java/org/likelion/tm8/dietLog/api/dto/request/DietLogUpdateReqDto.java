package org.likelion.tm8.dietLog.api.dto.request;

public record DietLogUpdateReqDto(
        String menu,
        boolean pass,
        Long water,
        String supplements,
        String particulars,
        Long kcal,
        Long carb,
        Long fat,
        Long protein
) {
}
