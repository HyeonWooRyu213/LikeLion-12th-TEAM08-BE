package org.likelion.tm8.weight.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.weight.domain.Weight;

import java.util.List;

@Builder
public record WeightListResDto(
        List<WeightInfoResDto> weights
) {
    public static WeightListResDto from(List<WeightInfoResDto> weights) {
        return WeightListResDto.builder()
                .weights(weights)
                .build();
    }
}
