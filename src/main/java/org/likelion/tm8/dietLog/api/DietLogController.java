package org.likelion.tm8.dietLog.api;

import lombok.RequiredArgsConstructor;
import org.likelion.tm8.diet.application.DietService;
import org.likelion.tm8.dietLog.api.dto.request.DietLogSaveReqDto;
import org.likelion.tm8.dietLog.api.dto.request.DietLogUpdateReqDto;
import org.likelion.tm8.dietLog.api.dto.response.DietLogInfoResDto;
import org.likelion.tm8.dietLog.api.dto.response.DietLogListResDto;
import org.likelion.tm8.dietLog.application.DietLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("dietLog")
public class DietLogController {
    private final DietLogService dietLogService;

    @PostMapping
    public ResponseEntity<String> dietLogSave(DietLogSaveReqDto dietLogSaveReqDto) {
        dietLogService.dietLogSave(dietLogSaveReqDto);
        return new ResponseEntity<>("정보저장 완료", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<DietLogListResDto> dietLogFindAll() {
        List<DietLogInfoResDto> dietLogs = dietLogService.dietLogFindAll();
        DietLogListResDto dietLogListResDto = DietLogListResDto.from(dietLogs);
        return new ResponseEntity<>(dietLogListResDto,HttpStatus.OK);
    }

    @PatchMapping("/{dietLogId}")
    public ResponseEntity<String> dietLogUpdate(@PathVariable("dietLogId") Long dietLogId, DietLogUpdateReqDto dietLogUpdateReqDto) {
        dietLogService.dietLogUpdate(dietLogId, dietLogUpdateReqDto);
        return new ResponseEntity<>("정보 수정", HttpStatus.OK);
    }

    @DeleteMapping("/{dietLogId}")
    public ResponseEntity<String> dietLogDelete(@PathVariable("dietLogId") Long dietLogId) {
        dietLogService.dietLogDelete(dietLogId);
        return new ResponseEntity<>("정보 삭제",HttpStatus.OK);
    }
}
