package org.likelion.tm8.diet.domain;

import jakarta.persistence.*;
import org.likelion.tm8.dietLog.domain.DietLog;
import org.likelion.tm8.today.domain.Today;
import org.likelion.tm8.user.domain.User;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_id")
    private Long dietId;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietLog> dietLogList = new ArrayList<>();

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Today> todayList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
