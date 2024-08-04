package org.likelion.tm8.today.api;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.likelion.tm8.today.api.request.TodaySaveReqDto;
import org.likelion.tm8.today.api.response.TodayInfoResDto;
import org.likelion.tm8.today.api.response.TodayListResDto;
import org.likelion.tm8.today.application.TodayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("today")
public class TodayController {
    private final TodayService todayService;

    @PostMapping
    public ResponseEntity<String> todaySave(@RequestBody TodaySaveReqDto todaySaveReqDto) {
        todayService.todaySave(todaySaveReqDto);
        return new ResponseEntity<>("오늘하루 저장", HttpStatus.OK);
    }

    @GetMapping("/gather")
    public ResponseEntity<TodayListResDto> todayFindAll() {
        List<TodayInfoResDto> todays = todayService.todayFindAll();
        TodayListResDto todayListResDto = TodayListResDto.from(todays);
        return new ResponseEntity<>(todayListResDto, HttpStatus.OK);
    }


=======
public class TodayController {
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
}
