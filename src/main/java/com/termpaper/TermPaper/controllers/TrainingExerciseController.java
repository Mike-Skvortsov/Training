package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.trainingExerciseDTO.TrainingExerciseDTO;
import com.termpaper.TermPaper.DTO.trainingPlanDTO.TrainingPlanGetAllDTO;
import com.termpaper.TermPaper.mappers.TrainingExerciseMapper;
import com.termpaper.TermPaper.models.TrainingExercise;
import com.termpaper.TermPaper.models.TrainingPlan;
import com.termpaper.TermPaper.services.TrainingExerciseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainingExercise")
public class TrainingExerciseController {
    @Autowired
    private TrainingExerciseMapper trainingExerciseMapper;
    private final TrainingExerciseService trainingExerciseService;
    @Autowired
    public TrainingExerciseController(TrainingExerciseService trainingExerciseService) {
        this.trainingExerciseService = trainingExerciseService;
    }
    @GetMapping("exercises/{trainingId}")
    public ResponseEntity<Iterable<TrainingExerciseDTO>> getTrainingExercise(@PathVariable int trainingId)
    {
        List<TrainingExercise> trainingExercises = (List<TrainingExercise>) trainingExerciseService.getAllTrainingExerciseInTrain(trainingId);

        // Конвертуємо список TrainingPlan в список TrainingPlanGetAllDTO
        List<TrainingExerciseDTO> trainingPlanGetAllDTOs = trainingExercises.stream()
                .map(trainingExerciseMapper::toTrainingExercise)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trainingPlanGetAllDTOs);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TrainingExerciseDTO>> getByIdTrainingExercise(@PathVariable int id)
    {
        Optional<TrainingExercise> trainingExercise = trainingExerciseService.getByIdTrainingExercise(id);
        return ResponseEntity.ok(trainingExercise.map(trainingExerciseMapper::toTrainingExercise));
    }
    @PostMapping("create")
    public ResponseEntity<TrainingExercise> createTrainingExercise(@RequestBody @Valid TrainingExercise model) {
        return new ResponseEntity<>(trainingExerciseService.create(model), HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<TrainingExercise> updateTrainingExercise(@PathVariable int id, @Valid @RequestBody TrainingExercise userDetails) {
        TrainingExercise updatedUser = trainingExerciseService.updateTrainingExercise(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        boolean isDeleted = trainingExerciseService.deleteTrainingExerciseById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
