package org.likelion.tm8.weight.application;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.likelion.tm8.user.domain.User;
import org.likelion.tm8.user.domain.repository.UserRepository;
import org.likelion.tm8.weight.api.dto.request.WeightSaveReqDto;
import org.likelion.tm8.weight.api.dto.request.WeightUpdateReqDto;
import org.likelion.tm8.weight.api.dto.response.ConditionInfoResDto;
import org.likelion.tm8.weight.api.dto.response.WeightInfoResDto;
import org.likelion.tm8.weight.domain.Weight;
import org.likelion.tm8.weight.domain.repository.WeightRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WeightService {
    private final WeightRepository weightRepository;
    private final UserRepository userRepository;

    @Transactional
    public void weightSave(WeightSaveReqDto weightSaveReqDto) {
        User user = userRepository.findById(weightSaveReqDto.userId())
                .orElseThrow(()-> new IllegalArgumentException("회원 없음"));

        Weight weight = Weight.builder()
                .weight(weightSaveReqDto.weight())
                .condition(weightSaveReqDto.condition())
                .user(user)
                .build();

        weightRepository.save(weight);
    }

    public WeightInfoResDto weightFindOne(Long weightId) {
        Weight weight = weightRepository.findById(weightId)
                .orElseThrow(()-> new IllegalArgumentException("기록 없음"));

        return WeightInfoResDto.from(weight);
    }

    public ConditionInfoResDto conditionFindOne(Long weightId) {
        Weight weight = weightRepository.findById(weightId)
                .orElseThrow(() -> new IllegalArgumentException("기록 없음"));

        return ConditionInfoResDto.from(weight);
    }

    @Transactional
    public void weightUpdate(Long weightId, WeightUpdateReqDto weightUpdateReqDto) {
        Weight weight = weightRepository.findById(weightId)
                .orElseThrow(()-> new IllegalArgumentException("기록 없음"));

        weight.update(weightUpdateReqDto);
    }

    @Transactional
    public void weightDelete(Long weightId) {
        Weight weight = weightRepository.findById(weightId)
                .orElseThrow(()-> new IllegalArgumentException("기록 없음"));

        weightRepository.delete(weight);
    }
}
