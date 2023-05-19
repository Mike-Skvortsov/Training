package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.repositories.ExerciseRepository;
import com.termpaper.TermPaper.repositories.MuscleGroupRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    public Optional<Exercise> getByIdExercise(int id)
    {
        return exerciseRepository.findById(id);
    }
    public Iterable<Exercise> getAllExercises()
    {
        return exerciseRepository.findAll();
    }
    public Iterable<Exercise> getAllExercisesInMuscleGroup(Integer id)
    {
        return exerciseRepository.findAllById(Collections.singleton(id));
    }
}
