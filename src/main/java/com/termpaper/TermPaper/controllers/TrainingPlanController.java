package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.TrainingPlan;
import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.services.TrainingPlanService;
import com.termpaper.TermPaper.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/trainingPlan")
@Validated
public class TrainingPlanController {
    @Autowired

    private final TrainingPlanService trainingPlanService;
    public TrainingPlanController(TrainingPlanService trainingPlanService)
    {
        this.trainingPlanService = trainingPlanService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TrainingPlan>> getByIdUser(@PathVariable int id)
    {
        return ResponseEntity.ok(trainingPlanService.getByIdTrainingPlan(id));
    }
    @GetMapping
    public ResponseEntity<Iterable<TrainingPlan>> getAllUsers() {
        return ResponseEntity.ok(trainingPlanService.getAllTrainingPlans());
    }
    @PostMapping("create")
    public ResponseEntity<TrainingPlan> createUser(@RequestBody @Valid TrainingPlan model) {
        return new ResponseEntity<>(trainingPlanService.create(model), HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<TrainingPlan> updateUser(@PathVariable int id, @Valid @RequestBody TrainingPlan userDetails) {
        TrainingPlan updatedUser = trainingPlanService.updateTrainingPlan(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        boolean isDeleted = trainingPlanService.deleteTrainingPlanById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
