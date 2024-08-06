package org.likelion.tm8.today.api.request;

public record TodaySaveReqDto(
        Long userId,
        Long exerciseId,
        Long dietId
) {
}
