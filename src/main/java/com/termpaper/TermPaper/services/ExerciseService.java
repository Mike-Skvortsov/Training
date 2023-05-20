package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.repositories.ExerciseRepository;
import com.termpaper.TermPaper.repositories.MuscleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class ExerciseService {
    @Autowired
    private final ExerciseRepository exerciseRepository;
    private final MuscleGroupRepository muscleGroupRepository;
    public ExerciseService(ExerciseRepository exerciseRepository, MuscleGroupRepository muscleGroupRepository) {
        this.exerciseRepository = exerciseRepository;
        this.muscleGroupRepository = muscleGroupRepository;
    }
    public Optional<Exercise> getByIdExercise(int id)
    {
        return exerciseRepository.findById(id);
    }
    public Iterable<Exercise> getAllExercises()
    {
        return exerciseRepository.findAll();
    }
    public List<Exercise> getAllExercisesInMuscleGroup(Integer id) {
        Optional<MuscleGroup> muscleGroup = muscleGroupRepository.findById(id);
        return muscleGroup.get().getExercises();
    }
}
