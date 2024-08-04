package org.likelion.tm8.diet.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record DietListResDto(
        List<DietInfoResDto> diets
) {
    public static DietListResDto from(List<DietInfoResDto> diets) {
        return DietListResDto.builder()
                .diets(diets)
                .build();
    }
}
