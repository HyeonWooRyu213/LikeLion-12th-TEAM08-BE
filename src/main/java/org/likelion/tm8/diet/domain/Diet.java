package org.likelion.tm8.diet.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.tm8.diet.api.dto.request.DietUpdateReqDto;
import org.likelion.tm8.dietLog.domain.DietLog;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.user.domain.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_id")
    private Long dietId;

    // 섭취한 칼로리
    @Column(name = "kcal")
    private Long kcal;

    // 섭취한 탄수화물
    @Column(name = "carb")
    private Long carb;

    // 섭취한 지방
    @Column(name = "fat")
    private Long fat;

    // 섭취한 단백질
    @Column(name = "protein")
    private Long protein;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietLog> dietLogList = new ArrayList<>();

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Today> todayList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Diet(Long dietId, Long kcal, Long carb, Long fat, Long protein, User user) {
        this.dietId = dietId;
        this.kcal = kcal;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
        this.user = user;
    }

    public void update(DietUpdateReqDto dietUpdateReqDto) {
        this.kcal = dietUpdateReqDto.kcal();
        this.carb = dietUpdateReqDto.carb();
        this.fat = dietUpdateReqDto.fat();
        this.protein = dietUpdateReqDto.protein();
    }
}
