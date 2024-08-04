package org.likelion.tm8.weight.domain.repository;

import org.likelion.tm8.weight.domain.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Long> {
}
