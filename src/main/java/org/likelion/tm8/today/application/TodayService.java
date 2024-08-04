package org.likelion.tm8.today.application;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.likelion.tm8.diet.domain.repository.DietRepository;
import org.likelion.tm8.exercise.domain.repository.ExerciseRepository;
import org.likelion.tm8.today.api.request.TodaySaveReqDto;
import org.likelion.tm8.today.api.request.TodayUpdateReqDto;
import org.likelion.tm8.today.api.response.TodayInfoResDto;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.today.domain.repository.TodayRepository;
import org.likelion.tm8.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TodayService {
    private final TodayRepository todayRepository;
    private final UserRepository userRepository;
    private final DietRepository dietRepository;
    private final ExerciseRepository exerciseRepository;

    @Transactional
    public void todaySave(TodaySaveReqDto todaySaveReqDto) {
        Today today = Today.builder()
                .kcal(todaySaveReqDto.kcal())
                .carb(todaySaveReqDto.carb())
                .fat(todaySaveReqDto.fat())
                .protein(todaySaveReqDto.Protein())
                .duration(todaySaveReqDto.duration())
                .build();

        todayRepository.save(today);
    }

    public List<TodayInfoResDto> todayFindAll() {
        List<Today> todays = todayRepository.findAll();
        return todays.stream()
                .map(TodayInfoResDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public TodayInfoResDto todayUpdate(Long todayId, TodayUpdateReqDto todayUpdateReqDto) {
        Today today = todayRepository.findById(todayId)
                .orElseThrow(()-> new IllegalArgumentException("오늘 정보 수정"));

        today.update(todayUpdateReqDto);

        return TodayInfoResDto.from(today);
    }
=======
public class TodayService {
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
}
