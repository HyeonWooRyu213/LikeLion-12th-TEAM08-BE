package org.likelion.tm8.weight.api;

import lombok.RequiredArgsConstructor;
import org.likelion.tm8.weight.api.dto.request.WeightSaveReqDto;
import org.likelion.tm8.weight.api.dto.request.WeightUpdateReqDto;
import org.likelion.tm8.weight.api.dto.response.ConditionInfoResDto;
import org.likelion.tm8.weight.api.dto.response.WeightInfoResDto;
import org.likelion.tm8.weight.application.WeightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/change")
public class WeightController {

    private final WeightService weightService;

    @PostMapping("/weight")
    public ResponseEntity<String> weightSave(@RequestBody WeightSaveReqDto weightSaveReqDto) {
        weightService.weightSave(weightSaveReqDto);

        return new ResponseEntity<>("체중 기록 완료", HttpStatus.CREATED);
    }

    @GetMapping("/weight/{weightId}")
    public ResponseEntity<WeightInfoResDto> weightFindOne(@PathVariable("weightId") Long weightId) {
        WeightInfoResDto weightInfoResDto = weightService.weightFindOne(weightId);

        return ResponseEntity.ok(weightInfoResDto);
    }

    @GetMapping("/condition/{weightId}")
    public ResponseEntity<ConditionInfoResDto> conditionFindOne(@PathVariable("weightId") Long weightId) {
        ConditionInfoResDto conditionInfoResDto = weightService.conditionFindOne(weightId);

        return ResponseEntity.ok(conditionInfoResDto);
    }

    @PatchMapping("/weight/{weightId}")
    public ResponseEntity<String> weightUpdate(@PathVariable("weightId") Long weightId, @RequestBody WeightUpdateReqDto weightUpdateReqDto) {
        weightService.weightUpdate(weightId, weightUpdateReqDto);
        return new ResponseEntity<>("체중 수정", HttpStatus.OK);
    }

    @DeleteMapping("/weight/{weightId}")
    public ResponseEntity<String> weightDelete(@PathVariable("weightId") Long weightId) {
        weightService.weightDelete(weightId);
        return new ResponseEntity<>("체중기록 삭제", HttpStatus.OK);
    }
}
