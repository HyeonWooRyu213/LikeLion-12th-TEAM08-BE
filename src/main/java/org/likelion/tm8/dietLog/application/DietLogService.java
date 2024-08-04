package org.likelion.tm8.dietLog.application;

import lombok.RequiredArgsConstructor;
import org.likelion.tm8.dietLog.api.dto.request.DietLogSaveReqDto;
import org.likelion.tm8.dietLog.api.dto.request.DietLogUpdateReqDto;
import org.likelion.tm8.dietLog.api.dto.response.DietLogInfoResDto;
import org.likelion.tm8.dietLog.domain.DietLog;
import org.likelion.tm8.dietLog.domain.repository.DietLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class DietLogService {
    private final DietLogRepository dietLogRepository;

    @Transactional
    public void dietLogSave(DietLogSaveReqDto dietLogSaveReqDto) {
        DietLog dietLog = DietLog.builder()
                .dietLogId(dietLogSaveReqDto.dietId())
                .menu(dietLogSaveReqDto.menu())
                .pass(dietLogSaveReqDto.pass())
                .water(dietLogSaveReqDto.water())
                .supplements(dietLogSaveReqDto.supplements())
                .particulars(dietLogSaveReqDto.particulars())
                .kcal(dietLogSaveReqDto.kcal())
                .carb(dietLogSaveReqDto.carb())
                .fat(dietLogSaveReqDto.fat())
                .protein(dietLogSaveReqDto.protein())
                .build();

        dietLogRepository.save(dietLog);
    }

    public List<DietLogInfoResDto> dietLogFindAll() {
        List<DietLog> dietLogs = dietLogRepository.findAll();
        return dietLogs.stream()
                .map(DietLogInfoResDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public DietLogInfoResDto dietLogUpdate(Long dietLogId, DietLogUpdateReqDto dietLogUpdateReqDto) {
        DietLog dietLog = dietLogRepository.findById(dietLogId)
                .orElseThrow(() -> new IllegalArgumentException("정보 수정"));

        dietLog.update(dietLogUpdateReqDto);

        return DietLogInfoResDto.from(dietLog);
    }

    @Transactional
    public DietLogInfoResDto dietLogDelete(Long dietLogId) {
        DietLog dietLog = dietLogRepository.findById(dietLogId)
                .orElseThrow(() -> new IllegalArgumentException("정보 삭제"));

        dietLogRepository.delete(dietLog);

        return DietLogInfoResDto.from(dietLog);
    }
}