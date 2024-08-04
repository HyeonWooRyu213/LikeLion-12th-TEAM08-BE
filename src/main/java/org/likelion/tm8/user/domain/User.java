package org.likelion.tm8.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.user.api.dto.request.UserUpdateReqDto;
import org.likelion.tm8.weight.domain.Weight;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String pw;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diet> dietList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exerciseList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Today> todayList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Weight> weightList = new ArrayList<>();

    @Builder
    private User(Long userId, String email, String pw, String name, int age) {
        this.userId = userId;
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.age = age;
    }

    public void update(UserUpdateReqDto userUpdateReqDto) {
        this.email = userUpdateReqDto.email();
        this.pw = userUpdateReqDto.pw();
        this.name = userUpdateReqDto.name();
        this.age = userUpdateReqDto.age();
    }
}
