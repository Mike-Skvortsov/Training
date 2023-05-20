package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.models.Training;
import com.termpaper.TermPaper.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TrainingService {
    @Autowired
    private final TrainingRepository trainingRepository;
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }
    public void create(Training model)
    {
        trainingRepository.save(model);
    }
    public Optional<Training> getByIdTraining(int id)
    {
        return trainingRepository.findById(id);
    }
    public Iterable<Training> getAllTraining()
    {
        return trainingRepository.findAll();
    }
}
