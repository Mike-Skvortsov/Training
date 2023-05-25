package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.trainingDTO.GetAllTrainingDTO;
import com.termpaper.TermPaper.mappers.TrainingMapper;
import com.termpaper.TermPaper.models.Training;
import com.termpaper.TermPaper.services.TrainingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    @Autowired

    private final TrainingService trainingService;
    private final TrainingMapper trainingMapper;
    @Autowired
    public TrainingController(TrainingService trainingService, TrainingMapper trainingMapper) {
        this.trainingService = trainingService;
        this.trainingMapper = trainingMapper;
    }
    @GetMapping()
    public ResponseEntity<Iterable<GetAllTrainingDTO>> getAllTrainings()
    {
        Iterable<Training> trainings =  trainingService.getAllTraining();
        List<GetAllTrainingDTO> trainingsDTO = StreamSupport.stream(trainings.spliterator(), false)
                .map(trainingMapper::toTrainingDTOWithoutOtherClasses)
                .toList();
        if (trainingsDTO.isEmpty()) {
            throw new ExceptionController.ExerciseNotFoundException("Training is not found");
        }
        return ResponseEntity.ok(trainingsDTO);
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
