package org.likelion.tm8.dietLog.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.tm8.diet.api.dto.request.DietUpdateReqDto;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.dietLog.api.dto.request.DietLogUpdateReqDto;

@Entity
@Getter
@NoArgsConstructor
public class DietLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dietLog_id")
    private Long dietLogId;

    // 식사 메뉴
    @Column(name = "menu")
    private String menu;

    // 단식 여부
    @Column(name = "pass")
    private Boolean pass;

    // 물 섭취량
    @Column(name = "water")
    private Long water;

    // 복용중인 영양제
    @Column(name = "supplements")
    private String supplements;

    // 특이사항
    @Column(name = "particulars")
    private String particulars;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    // 섭취 영양성분
    @Column(name = "kcal")
    private Long kcal;

    @Column(name = "carb")
    private Long carb;

    @Column(name = "fat")
    private Long fat;

    @Column(name = "protein")
    private Long protein;


    @Builder
    private DietLog(Long dietLogId, Diet diet, String menu, Boolean pass, Long water, String supplements, String particulars, Long kcal, Long carb, Long fat, Long protein) {
        this.dietLogId = dietLogId;
        this.diet = diet;
        this.menu = menu;
        this.pass = pass;
        this.water = water;
        this.supplements = supplements;
        this.particulars = particulars;
        this.kcal = kcal;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
    }

    public void update(DietLogUpdateReqDto dietLogUpdateReqDto) {
        this.menu = dietLogUpdateReqDto.menu();
        this.pass = dietLogUpdateReqDto.pass();
        this.water = dietLogUpdateReqDto.water();
        this.supplements = dietLogUpdateReqDto.supplements();
        this.particulars = dietLogUpdateReqDto.particulars();
        this.kcal = dietLogUpdateReqDto.kcal();
        this.carb = dietLogUpdateReqDto.carb();
        this.fat = dietLogUpdateReqDto.fat();
        this.protein = dietLogUpdateReqDto.protein();
    }
}