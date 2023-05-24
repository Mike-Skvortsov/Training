package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.exerciseDTO.ExerciseDTO;
import com.termpaper.TermPaper.mappers.ExerciseMapper;
import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    private final ExerciseMapper exerciseMapper;
    private final ExerciseService exerciseService;
    @Autowired
    public ExerciseController(ExerciseMapper exerciseMapper, ExerciseService exerciseService)
    {
        this.exerciseMapper = exerciseMapper;
        this.exerciseService = exerciseService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ExerciseDTO>> getByIdExercise(@PathVariable int id)
    {
        Optional<Exercise> exercise = exerciseService.getByIdExercise(id);
        return ResponseEntity.ok(exercise.map(exerciseMapper::toExerciseDTO));
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<ExerciseDTO>> getAllExercises()
    {
        Iterable<Exercise> exercises = exerciseService.getAllExercises();
        List<ExerciseDTO> exercisesDTO = StreamSupport.stream(exercises.spliterator(), false)
                .map(exerciseMapper::toExerciseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(exercisesDTO);
    }
}
