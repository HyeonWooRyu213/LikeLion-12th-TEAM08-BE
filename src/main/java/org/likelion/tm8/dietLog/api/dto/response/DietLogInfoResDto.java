package org.likelion.tm8.dietLog.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.dietLog.domain.DietLog;

@Builder
public record DietLogInfoResDto(
        Long dietLogId,
        String menu,
        boolean pass,
        Long water,
        String supplements,
        String particulars,
        Long dietId,
        Long kcal,
        Long carb,
        Long fat,
        Long protein
) {
    public static DietLogInfoResDto from(DietLog dietLog) {
        return DietLogInfoResDto.builder()
                .dietLogId(dietLog.getDietLogId())
                .menu(dietLog.getMenu())
                .pass(dietLog.isPass())
                .water(dietLog.getWater())
                .particulars(dietLog.getParticulars())
                .dietId(dietLog.getDiet().getDietId())
                .kcal(dietLog.getKcal())
                .carb(dietLog.getCarb())
                .fat(dietLog.getFat())
                .protein(dietLog.getProtein())
                .build();
    }
}
