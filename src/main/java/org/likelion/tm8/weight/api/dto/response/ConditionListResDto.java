package org.likelion.tm8.weight.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ConditionListResDto(
        List<ConditionInfoResDto> conditions
) {
    public static ConditionListResDto from(List<ConditionInfoResDto> conditions) {
        return ConditionListResDto.builder()
                .conditions(conditions)
                .build();
    }
}