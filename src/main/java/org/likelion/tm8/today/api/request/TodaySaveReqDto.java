package org.likelion.tm8.today.api.request;

public record TodaySaveReqDto(
        Long kcal,
        Long carb,
        Long fat,
        Long Protein,
        Long duration
) {
}
