package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.exerciseDTO.ExerciseDTO;
import com.termpaper.TermPaper.mappers.ExerciseMapper;
import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.services.ExerciseService;
import com.termpaper.TermPaper.services.MuscleGroupService;
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
    private final MuscleGroupService muscleGroupService;
    @Autowired
    public ExerciseController(ExerciseMapper exerciseMapper, ExerciseService exerciseService, MuscleGroupService muscleGroupService)
    {
        this.exerciseMapper = exerciseMapper;
        this.exerciseService = exerciseService;
        this.muscleGroupService = muscleGroupService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> getByIdExercise(@PathVariable int id) {
        Exercise exercise = exerciseService.getByIdExercise(id)
                .orElseThrow(() -> new ExceptionController.ExerciseNotFoundException("Object with this id does not exist: " + id));
        return ResponseEntity.ok(exerciseMapper.toExerciseDTO(exercise));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExerciseDTO>> getAllExercises() {
        Iterable<Exercise> exercises = exerciseService.getAllExercises();
        List<ExerciseDTO> exercisesDTO = StreamSupport.stream(exercises.spliterator(), false)
                .map(exerciseMapper::toExerciseDTO)
                .collect(Collectors.toList());

        if (exercisesDTO.isEmpty()) {
            throw new ExceptionController.ExerciseNotFoundException("No exercises found");
        }

        return ResponseEntity.ok(exercisesDTO);
    }
    @GetMapping("/muscleGroup/{muscleId}")
    public ResponseEntity<List<ExerciseDTO>> getByIdMuscleGroup(@PathVariable int muscleId) {
        if(muscleGroupService.getByIdMuscle(muscleId).isEmpty())
        {
            throw new ExceptionController.ExerciseNotFoundException("No muscle group found");
        }
        Iterable<Exercise> exercises = exerciseService.getAllExercisesInMuscleGroup(muscleId);
        List<ExerciseDTO> exercisesDTO = StreamSupport.stream(exercises.spliterator(), false)
                .map(exerciseMapper::toExerciseDTO)
                .collect(Collectors.toList());

        if (exercisesDTO.isEmpty()) {
            throw new ExceptionController.ExerciseNotFoundException("No exercises found");
        }
        return ResponseEntity.ok(exercisesDTO);
    }

}
