package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.TrainingExercise;
import com.termpaper.TermPaper.models.TrainingPlan;
import com.termpaper.TermPaper.services.TrainingExerciseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/trainingExercise")
public class TrainingExerciseController {
    @Autowired

    private final TrainingExerciseService trainingExerciseService;
    @Autowired
    public TrainingExerciseController(TrainingExerciseService trainingExerciseService) {
        this.trainingExerciseService = trainingExerciseService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<TrainingExercise>> getFullMuscleGroup()
    {
        return ResponseEntity.ok(trainingExerciseService.getAllTrainingExercise());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TrainingExercise>> getByIdTrainingExercise(@PathVariable int id)
    {
        return ResponseEntity.ok(trainingExerciseService.getByIdTrainingExercise(id));
    }
    @PostMapping("create")
    public ResponseEntity<TrainingExercise> createUser(@RequestBody @Valid TrainingExercise model) {
        return new ResponseEntity<>(trainingExerciseService.create(model), HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<TrainingExercise> updateUser(@PathVariable int id, @Valid @RequestBody TrainingExercise userDetails) {
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
