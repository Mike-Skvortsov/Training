package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.Training;
import com.termpaper.TermPaper.models.TrainingExercise;
import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.repositories.TrainingExerciseRepository;
import com.termpaper.TermPaper.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TrainingExerciseService {
    @Autowired
    private final TrainingExerciseRepository trainingExerciseRepository;
    public TrainingExerciseService(TrainingExerciseRepository trainingExerciseRepository) {
        this.trainingExerciseRepository = trainingExerciseRepository;
    }
    public TrainingExercise create(TrainingExercise model)
    {
        trainingExerciseRepository.save(model);
        return  model;
    }
    public Optional<TrainingExercise> getByIdTrainingExercise(int id)
    {
        return trainingExerciseRepository.findById(id);
    }
    public Iterable<TrainingExercise> getAllTrainingExercise()
    {
        return trainingExerciseRepository.findAll();
    }
    public TrainingExercise updateTrainingExercise(int id, TrainingExercise trainingExerciseDetails) {
        Optional<TrainingExercise> optionalTrainingExercise = trainingExerciseRepository.findById(id);
        if (optionalTrainingExercise.isPresent()) {
            TrainingExercise trainingExercise = optionalTrainingExercise.get();
            trainingExercise.setRepeats(trainingExerciseDetails.getRepeats());
            trainingExercise.setSets(trainingExerciseDetails.getSets());
            trainingExercise.setTraining(trainingExerciseDetails.getTraining());
            trainingExercise.setRestTime(trainingExerciseDetails.getRestTime());
            trainingExercise.setExercise(trainingExerciseDetails.getExercise());
            return trainingExerciseRepository.save(trainingExercise);
        } else {
            return null;
        }
    }
    public boolean deleteTrainingExerciseById(int id) {
        Optional<TrainingExercise> optionalTrainingExercise = trainingExerciseRepository.findById(id);
        if (optionalTrainingExercise.isPresent()) {
            trainingExerciseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
