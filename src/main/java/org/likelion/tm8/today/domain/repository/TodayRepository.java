package org.likelion.tm8.today.domain.repository;

import org.likelion.tm8.today.domain.Today;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodayRepository extends JpaRepository<Today, Long> {
}
