package org.likelion.tm8.dietLog.api.dto.response;

import lombok.Builder;
import org.likelion.tm8.dietLog.domain.DietLog;

import java.util.List;

@Builder
public record DietLogListResDto(
        List<DietLogInfoResDto> dietLogs
) {
    public static DietLogListResDto from(List<DietLogInfoResDto> dietLogs) {
        return DietLogListResDto.builder()
                .dietLogs(dietLogs)
                .build();
    }
}
