package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.trainingDTO.GetOneTrainingWithoutTrainingExercises;
import com.termpaper.TermPaper.mappers.TrainingMapper;
import com.termpaper.TermPaper.models.Training;
import com.termpaper.TermPaper.models.TrainingPlan;
import com.termpaper.TermPaper.services.TrainingPlanService;
import com.termpaper.TermPaper.services.TrainingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    @Autowired

    private final TrainingService trainingService;
    private final TrainingPlanService trainingPlanService;
    private final TrainingMapper trainingMapper;
    @Autowired
    public TrainingController(TrainingService trainingService, TrainingPlanService trainingPlanService, TrainingMapper trainingMapper) {
        this.trainingService = trainingService;
        this.trainingPlanService = trainingPlanService;
        this.trainingMapper = trainingMapper;
    }
    @GetMapping()
    public ResponseEntity<Iterable<GetOneTrainingWithoutTrainingExercises>> getAllTrainings() {
        List<Training> trainings = (List<Training>) trainingService.getAllTraining();
        if (trainings.isEmpty()) {
            throw new ExceptionController.ExerciseNotFoundException("Training is not found");
        }
        List<GetOneTrainingWithoutTrainingExercises> trainingsDTO = trainings.stream()
                .map(trainingMapper::toTrainingDTOWithTrainingExercise)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trainingsDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetOneTrainingWithoutTrainingExercises> getByIdTraining(@PathVariable int id)
    {
        Training training = trainingService.getByIdTraining(id)
                .orElseThrow(() -> new ExceptionController.ExerciseNotFoundException("Training with this id does not exist: " + id));;
        return ResponseEntity.ok(trainingMapper.toTrainingDTOWithTrainingExercise(training));
    }
    @PostMapping("/create")
    public ResponseEntity<Training> createTraining(@RequestBody @Valid GetOneTrainingWithoutTrainingExercises model,
                                                   @RequestParam int trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanService.getByIdTrainingPlan(trainingPlanId)
                .orElseThrow(() -> new ExceptionController.ExerciseNotFoundException("Training plan with this id does not exist: " + trainingPlanId));
        Training training = trainingMapper.toTraining(model);
        training.setTrainingPlan(trainingPlan);
        return new ResponseEntity<>(trainingService.createTraining(training), HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Training> updateTraining(@PathVariable int id, @Valid @RequestBody Training training) {
        Training updatedTraining = trainingService.updateTraining(id, training);
        if (updatedTraining != null) {
            return ResponseEntity.ok(updatedTraining);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteByIdTraining(@PathVariable int id) {
        boolean isDeleted = trainingService.deleteTraining(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
