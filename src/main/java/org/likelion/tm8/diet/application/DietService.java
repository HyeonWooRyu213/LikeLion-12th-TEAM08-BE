package org.likelion.tm8.diet.application;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.likelion.tm8.diet.api.dto.request.DietSaveReqDto;
import org.likelion.tm8.diet.api.dto.request.DietUpdateReqDto;
import org.likelion.tm8.diet.api.dto.response.DietInfoResDto;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.diet.domain.repository.DietRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DietService {

    private final DietRepository dietRepository;

    @Transactional
    public void dietSave(DietSaveReqDto dietSaveReqDto) {
        Diet diet = Diet.builder()
                .kcal(dietSaveReqDto.kcal())
                .carb(dietSaveReqDto.carb())
                .fat(dietSaveReqDto.fat())
                .protein(dietSaveReqDto.protein())
                .build();

        dietRepository.save(diet);
    }

    public List<DietInfoResDto> dietFIndAll() {
        List<Diet> diets = dietRepository.findAll();
        return diets.stream()
                .map(DietInfoResDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public DietInfoResDto dietUpdate(Long dietId, DietUpdateReqDto dietUpdateReqDto) {
        Diet diet = dietRepository.findById(dietId)
                .orElseThrow(()-> new IllegalArgumentException("정보 없음"));

        diet.update(dietUpdateReqDto);
        return DietInfoResDto.from(diet);
    }

    @Transactional
    public DietInfoResDto dietDelete(Long dietId) {
        Diet diet = dietRepository.findById(dietId)
                .orElseThrow(()-> new IllegalArgumentException("정보 없음"));

        dietRepository.delete(diet);

        return DietInfoResDto.from(diet);
    }
=======
public class DietService {
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
}
