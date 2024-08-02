package org.likelion.tm8.user.domain;

import jakarta.persistence.*;
import org.likelion.tm8.diet.domain.Diet;
import org.likelion.tm8.exercise.domain.Exercise;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.weight.domain.Weight;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diet> dietList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exerciseList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Today> todayList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Weight> weightList = new ArrayList<>();
}
