package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.Training;
import com.termpaper.TermPaper.models.TrainingExercise;
import com.termpaper.TermPaper.repositories.TrainingExerciseRepository;
import com.termpaper.TermPaper.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TrainingExerciseService {
    @Autowired
    private final TrainingExerciseRepository trainingExerciseRepository;
    public TrainingExerciseService(TrainingExerciseRepository trainingExerciseRepository) {
        this.trainingExerciseRepository = trainingExerciseRepository;
    }
    public void create(TrainingExercise model)
    {
        trainingExerciseRepository.save(model);
    }
    public Optional<TrainingExercise> getByIdTraining(int id)
    {
        return trainingExerciseRepository.findById(id);
    }
    public Iterable<TrainingExercise> getAllTraining()
    {
        return trainingExerciseRepository.findAll();
    }
}
