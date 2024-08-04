package org.likelion.tm8.diet.api;

import lombok.RequiredArgsConstructor;
import org.likelion.tm8.diet.api.dto.request.DietSaveReqDto;
import org.likelion.tm8.diet.api.dto.request.DietUpdateReqDto;
import org.likelion.tm8.diet.api.dto.response.DietInfoResDto;
import org.likelion.tm8.diet.api.dto.response.DietListResDto;
import org.likelion.tm8.diet.application.DietService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("diet")
public class DietController {

    private final DietService dietService;

    @PostMapping
    public ResponseEntity<String> dietSave(@RequestBody DietSaveReqDto dietSaveReqDto) {
        dietService.dietSave(dietSaveReqDto);
        return new ResponseEntity<>("섭취량 저장", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<DietListResDto> dietFindAll() {
        List<DietInfoResDto> diets = dietService.dietFIndAll();
        DietListResDto dietListResDto = DietListResDto.from(diets);
        return new ResponseEntity<>(dietListResDto, HttpStatus.OK);
    }

    @PatchMapping("/{dietId}")
    public ResponseEntity<String> dietUpdate(@PathVariable("dietId") Long dietId, DietUpdateReqDto dietUpdateReqDto) {
        dietService.dietUpdate(dietId, dietUpdateReqDto);
        return new ResponseEntity<>("섭취량 수정", HttpStatus.OK);
    }

    @DeleteMapping("{dietId}")
    public ResponseEntity<String> dietDelete(@PathVariable("dietId") Long dietId) {
        dietService.dietDelete(dietId);
        return new ResponseEntity<>("섭취량 삭제", HttpStatus.OK);
    }
}