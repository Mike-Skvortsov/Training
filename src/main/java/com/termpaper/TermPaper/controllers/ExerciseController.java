package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;
    @Autowired
    public ExerciseController(ExerciseService exerciseService)
    {
        this.exerciseService = exerciseService;
    }
    @GetMapping("/{id}")
    public Optional<Exercise> getByIdExercise(@PathVariable int id)
    {
        return exerciseService.getByIdExercise(id);
    }
    @GetMapping("/all")
    public Iterable<Exercise> getAllExercises()
    {
        return exerciseService.getAllExercises();
    }
    @GetMapping("/MuscleGroup/{muscleGroupId}")
    public  Iterable<Exercise> getAllExercisesInMuscleGroup(@PathVariable int muscleGroupId)
    {
        return exerciseService.getAllExercisesInMuscleGroup(muscleGroupId);
    }
}
