package org.likelion.tm8.weight.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.weight.domain.Weight;

@Builder
public record WeightInfoResDto(
        Long weightId,
        Long weight,
        Long userId
) {
    public static WeightInfoResDto from(Weight weight) {
        return WeightInfoResDto.builder()
                .weightId(weight.getWeightId())
                .weight(weight.getWeight())
                .build();
    }
}
