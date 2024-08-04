package org.likelion.tm8.weight.api.dto.request;

public record WeightSaveReqDto(
        Long weight,
        String condition,
        Long userId
) {
}
