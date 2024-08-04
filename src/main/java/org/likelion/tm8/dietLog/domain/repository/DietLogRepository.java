package org.likelion.tm8.dietLog.domain.repository;

import org.likelion.tm8.dietLog.domain.DietLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietLogRepository extends JpaRepository<DietLog, Long> {
}
