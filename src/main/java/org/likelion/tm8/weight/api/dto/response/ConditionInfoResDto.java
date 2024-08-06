package org.likelion.tm8.weight.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.weight.domain.Weight;

@Builder
public record ConditionInfoResDto(
        Long weightId,
        String condition,
        Long userId
) {
    public static ConditionInfoResDto from(Weight weight) {
        return ConditionInfoResDto.builder()
                .weightId(weight.getWeightId())
                .condition(weight.getCondition())
                .userId(weight.getUser().getUserId())
                .build();
    }
}
