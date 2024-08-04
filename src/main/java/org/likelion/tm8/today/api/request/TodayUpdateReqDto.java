package org.likelion.tm8.today.api.request;

public record TodayUpdateReqDto(
        Long kcal,
        Long carb,
        Long fat,
        Long Protein,
        Long duration
) {
}
