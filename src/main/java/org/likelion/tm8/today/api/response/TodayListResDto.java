package org.likelion.tm8.today.api.response;

import lombok.Builder;

import java.util.List;

@Builder
public record TodayListResDto(
        List<TodayInfoResDto> todays
) {
    public static TodayListResDto from(List<TodayInfoResDto> todays) {
        return TodayListResDto.builder()
                .todays(todays)
                .build();
    }
}
