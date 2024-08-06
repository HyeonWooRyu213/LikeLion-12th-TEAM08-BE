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
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    @Column(name = "email")
    private String email;

    @Column(name = "passwords")
    private String pw;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "height")
    private int height;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diet> dietList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exerciseList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Today> todayList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Weight> weightList = new ArrayList<>();

    @Builder
    private User(Long Id, String email, String name, int age, String gender, int height) {
        this.Id = Id;
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }

    public void update(UserUpdateReqDto userUpdateReqDto) {
        this.email = userUpdateReqDto.email();
        this.name = userUpdateReqDto.name();
        this.age = userUpdateReqDto.age();
    }
}
