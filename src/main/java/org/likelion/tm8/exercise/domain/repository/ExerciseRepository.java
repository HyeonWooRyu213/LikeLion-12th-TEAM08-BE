package org.likelion.tm8.exercise.domain.repository;


import org.likelion.tm8.exercise.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
