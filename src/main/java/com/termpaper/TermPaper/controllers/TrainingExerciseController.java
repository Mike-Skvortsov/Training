package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.TrainingExercise;
import com.termpaper.TermPaper.services.TrainingExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
