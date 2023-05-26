package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.trainingPlanDTO.TrainingPlanGetAllDTO;
import com.termpaper.TermPaper.DTO.trainingPlanDTO.TrainingPlanWithoutId;
import com.termpaper.TermPaper.mappers.TrainingPlanMapper;
import com.termpaper.TermPaper.models.TrainingPlan;
import com.termpaper.TermPaper.services.TrainingPlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainingPlan")
@Validated
public class TrainingPlanController {
    @Autowired
    private TrainingPlanMapper trainingPlanMapper;
    private final TrainingPlanService trainingPlanService;
    public TrainingPlanController(TrainingPlanService trainingPlanService)
    {
        this.trainingPlanService = trainingPlanService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrainingPlanWithoutId> getByIdTrainingPlan(@PathVariable int id)
    {

        TrainingPlan trainingPlan = trainingPlanService.getByIdTrainingPlan(id)
                .orElseThrow(() -> new ExceptionController.ExerciseNotFoundException("Training plan with this id does not exist: " + id));
        return ResponseEntity.ok(trainingPlanMapper.toDTOWithTrainings(trainingPlan));
    }

    @GetMapping
    public ResponseEntity<List<TrainingPlanGetAllDTO>> getAllTrainingPlans() {
        List<TrainingPlan> trainingPlans = (List<TrainingPlan>) trainingPlanService.getAllTrainingPlans();
        if (trainingPlans.isEmpty()) {
            throw new ExceptionController.ExerciseNotFoundException("Training plan in this training not found");
        }
        List<TrainingPlanGetAllDTO> trainingPlanGetAllDTOs = trainingPlans.stream()
                .map(trainingPlanMapper::toGetAllWithIdDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trainingPlanGetAllDTOs);
    }

    @PostMapping("create")
    public ResponseEntity<TrainingPlan> createTrainingPlan(@RequestBody @Valid TrainingPlanWithoutId trainingPlanCreateDTO ) {
        TrainingPlan model = trainingPlanMapper.toEntity(trainingPlanCreateDTO);
        return new ResponseEntity<>(trainingPlanService.create(model), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<TrainingPlan> updateTrainingPlan(@PathVariable int id, @Valid @RequestBody TrainingPlanWithoutId userDetails) {
        TrainingPlan trainingPlan = trainingPlanMapper.toEntity(userDetails);
        TrainingPlan updatedTrainingPlan = trainingPlanService.updateTrainingPlan(id, trainingPlan);
        if (updatedTrainingPlan != null) {
            return ResponseEntity.ok(updatedTrainingPlan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteByIdTrainingPlan(@PathVariable int id) {
        boolean isDeleted = trainingPlanService.deleteTrainingPlanById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
