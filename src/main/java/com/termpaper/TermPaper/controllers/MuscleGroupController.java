package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.services.ExerciseService;
import com.termpaper.TermPaper.services.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/muscleGroup")
public class MuscleGroupController {
    @Autowired

    private final MuscleGroupService muscleGroupService;
    private final ExerciseService exerciseService;
    @Autowired
    public MuscleGroupController(MuscleGroupService muscleGroupService, ExerciseService exerciseService) {
        this.muscleGroupService = muscleGroupService;
        this.exerciseService = exerciseService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<MuscleGroup>> getFullMuscleGroup()
    {
        return ResponseEntity.ok(muscleGroupService.getAllMuscleGroup());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<MuscleGroup>> getByIdMuscleGroup(@PathVariable int id) {
        Optional<MuscleGroup> muscleGroup = muscleGroupService.getByIdMuscle(id);
        if (muscleGroup.isPresent()) {
            List<Exercise> exercises = (List<Exercise>) exerciseService.getAllExercisesInMuscleGroup(id);
            muscleGroup.get().setExercises(exercises);
        }
        return ResponseEntity.ok(muscleGroup);
    }
    @GetMapping("/exercises/{muscleGroupId}")
    public ResponseEntity<Iterable<Exercise>> getAllExercisesInMuscleGroup(@PathVariable int muscleGroupId) {
        return ResponseEntity.ok(exerciseService.getAllExercisesInMuscleGroup(muscleGroupId));
    }
}
