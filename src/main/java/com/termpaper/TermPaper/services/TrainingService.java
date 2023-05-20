package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.Training;
import com.termpaper.TermPaper.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
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
    public Training createTraining(Training training)
    {
        trainingRepository.save(training);
        return training;
    }
    public Training updateTraining(int id, Training training) {
        Optional<Training> optionalTraining = trainingRepository.findById(id);
        if (optionalTraining.isPresent()) {
            Training updatedTraining = optionalTraining.get();
            updatedTraining.setName(training.getName());
            updatedTraining.setProgress(training.getProgress());
            updatedTraining.setIsActive(training.getIsActive());
            updatedTraining.setTime(training.getTime());
            updatedTraining.setDescription(training.getDescription());
            return trainingRepository.save(updatedTraining);
        } else {
            return null;
        }
    }
    public boolean deleteTraining(int id)
    {
        if(trainingRepository.findById(id).isPresent())
        {
            trainingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
