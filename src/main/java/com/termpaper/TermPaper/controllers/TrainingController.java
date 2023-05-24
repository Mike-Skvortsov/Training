package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.Training;
import com.termpaper.TermPaper.services.TrainingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    @Autowired

    private final TrainingService trainingService;
    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<Training>> getFullMuscleGroup()
    {
        return ResponseEntity.ok(trainingService.getAllTraining());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Training>> getByIdTraining(@PathVariable int id)
    {
        return ResponseEntity.ok(trainingService.getByIdTraining(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Training> createTraining(@RequestBody @Valid Training model) {
        return new ResponseEntity<>(trainingService.createTraining(model), HttpStatus.CREATED);
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
