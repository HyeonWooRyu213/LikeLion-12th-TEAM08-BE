package org.likelion.tm8.diet.domain;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.tm8.diet.api.dto.request.DietUpdateReqDto;
=======
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
import org.likelion.tm8.dietLog.domain.DietLog;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.user.domain.User;

import java.util.ArrayList;
import java.util.List;

@Entity
<<<<<<< HEAD
@Getter
@NoArgsConstructor
=======
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_id")
    private Long dietId;

<<<<<<< HEAD
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

=======
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietLog> dietLogList = new ArrayList<>();

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Today> todayList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
<<<<<<< HEAD

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


=======
>>>>>>> 9ebebefa0296ea18f78e38b4d3f5a7c4aef7409e
}
