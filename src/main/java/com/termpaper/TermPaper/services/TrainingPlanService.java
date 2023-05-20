package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.TrainingPlan;
import com.termpaper.TermPaper.repositories.TrainingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainingPlanService {
    @Autowired
    private final TrainingPlanRepository trainingPlanRepository;
    public TrainingPlanService(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }
    public TrainingPlan create(TrainingPlan model)
    {
        trainingPlanRepository.save(model);
        return model;
    }
    public Optional<TrainingPlan> getByIdTrainingPlan(int id)
    {
        return trainingPlanRepository.findById(id);
    }
    public Iterable<TrainingPlan> getAllTrainingPlans()
    {
        return trainingPlanRepository.findAll();
    }
    public TrainingPlan updateTrainingPlan(int id, TrainingPlan updatedTrainingPlan) {
        Optional<TrainingPlan> optionalUser = trainingPlanRepository.findById(id);
        if (optionalUser.isPresent()) {
            TrainingPlan trainingPlan = optionalUser.get();
            trainingPlan.setName(updatedTrainingPlan.getName());
            trainingPlan.setTrainings(updatedTrainingPlan.getTrainings());
            return trainingPlanRepository.save(trainingPlan);
        } else {
            return null;
        }
    }

    public boolean deleteTrainingPlanById(int id) {
        Optional<TrainingPlan> optionalUser = trainingPlanRepository.findById(id);
        if (optionalUser.isPresent()) {
            trainingPlanRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
