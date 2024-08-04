package org.likelion.tm8.diet.domain.repository;

import org.likelion.tm8.diet.domain.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet, Long> {
}
