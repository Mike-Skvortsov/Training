package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.trainingExerciseDTO.TrainingExerciseDTO;
import com.termpaper.TermPaper.DTO.trainingExerciseDTO.TrainingExerciseDTOWithoutTrainingAndExercise;
import com.termpaper.TermPaper.mappers.TrainingExerciseMapper;
import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.models.Training;
import com.termpaper.TermPaper.models.TrainingExercise;
import com.termpaper.TermPaper.services.ExerciseService;
import com.termpaper.TermPaper.services.TrainingExerciseService;
import com.termpaper.TermPaper.services.TrainingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainingExercise")
public class TrainingExerciseController {
    @Autowired
    private TrainingExerciseMapper trainingExerciseMapper;
    private final TrainingExerciseService trainingExerciseService;
    private final ExerciseService exerciseService;
    private final TrainingService trainingService;
    @Autowired
    public TrainingExerciseController(TrainingExerciseService trainingExerciseService, ExerciseService exerciseService, TrainingService trainingService) {
        this.trainingExerciseService = trainingExerciseService;
        this.exerciseService = exerciseService;
        this.trainingService = trainingService;
    }
    @GetMapping("exercises/{trainingId}")
    public ResponseEntity<?> getTrainingExercise(@PathVariable int trainingId)
    {
        trainingService.getByIdTraining(trainingId)
                .orElseThrow(() -> new ExceptionController.ExerciseNotFoundException("Training with this id does not exist: " + trainingId));

        List<TrainingExercise> trainingExercises = (List<TrainingExercise>) trainingExerciseService.getAllTrainingExerciseInTrain(trainingId);
        if (trainingExercises.isEmpty()) {
            throw new ExceptionController.ExerciseNotFoundException("Training exercises in this training not found");
        }
        List<TrainingExerciseDTO> trainingPlanGetAllDTOs = trainingExercises.stream()
                .map(trainingExerciseMapper::toTrainingExercise)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trainingPlanGetAllDTOs);
    }
    //@GetMapping("/{id}")
    //public ResponseEntity<Optional<TrainingExerciseDTO>> getByIdTrainingExercise(@PathVariable int id)
    //{
    //    Optional<TrainingExercise> trainingExercise = trainingExerciseService.getByIdTrainingExercise(id);
    //    return ResponseEntity.ok(trainingExercise.map(trainingExerciseMapper::toTrainingExercise));
    //}

    @PostMapping("create")
    public ResponseEntity<TrainingExercise> createTrainingExercise(@RequestBody @Valid TrainingExerciseDTOWithoutTrainingAndExercise model, @RequestParam int exerciseId, @RequestParam int trainingId) {
        if (trainingService.getByIdTraining(trainingId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Training not found");
        }

        if (exerciseService.getByIdExercise(exerciseId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found");
        }
        Exercise exercise = exerciseService.getByIdExercise(exerciseId).get();
        Training training = trainingService.getByIdTraining(trainingId).get();

        List<TrainingExercise> trainingExercises = (List<TrainingExercise>) trainingExerciseService.getAllTrainingExerciseInTrain(trainingId);
        for (TrainingExercise trainingExercise : trainingExercises) {
            if (trainingExercise.getExercise().getId() == exerciseId) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Exercise already exists in this training");
            }
        }
        TrainingExercise trainingExercise = trainingExerciseMapper.toTrainingExercise(model);

        trainingExercise.setExercise(exercise);
        trainingExercise.setTraining(training);

        return new ResponseEntity<>(trainingExerciseService.create(trainingExercise), HttpStatus.CREATED);
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
