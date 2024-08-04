package org.likelion.tm8.exercise.api;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.likelion.tm8.exercise.api.dto.request.ExerciseSaveReqDto;
import org.likelion.tm8.exercise.api.dto.request.ExerciseUpdateReqDto;
import org.likelion.tm8.exercise.api.dto.response.ExerciseInfoResDto;
import org.likelion.tm8.exercise.api.dto.response.ExerciseListResDto;
import org.likelion.tm8.exercise.application.ExerciseService;
import org.likelion.tm8.exercise.domain.Exercise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<String> exerciseSave(@RequestBody ExerciseSaveReqDto exerciseSaveReqDto) {
        exerciseService.exerciseSave(exerciseSaveReqDto);
        return new ResponseEntity<>("운동 저장", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ExerciseListResDto> exerciseFindAll() {
        List<ExerciseInfoResDto> exercises = exerciseService.exerciseFindAll();
        ExerciseListResDto exerciseListResDto = ExerciseListResDto.from(exercises);
        return new ResponseEntity<>(exerciseListResDto, HttpStatus.OK);
    }

    @PatchMapping("/{exerciseId}")
    public ResponseEntity<String> exerciseUpdate(@PathVariable Long exerciseId, @RequestBody ExerciseUpdateReqDto exerciseUpdateReqDto) {
        exerciseService.exerciseUpdate(exerciseId,exerciseUpdateReqDto);
        return new ResponseEntity<>("운동 수정",HttpStatus.OK);
    }
=======
public class ExerciseController {
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
}
