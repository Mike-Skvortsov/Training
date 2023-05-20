package com.termpaper.TermPaper.repositories;

import com.termpaper.TermPaper.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
