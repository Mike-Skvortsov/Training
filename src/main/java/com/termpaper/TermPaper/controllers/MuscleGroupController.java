package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.muscleGroupDTO.MuscleGroupDTOWithExercises;
import com.termpaper.TermPaper.DTO.muscleGroupDTO.MuscleGroupWithoutExercisesDTO;
import com.termpaper.TermPaper.mappers.MuscleGroupMapper;
import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.services.ExerciseService;
import com.termpaper.TermPaper.services.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/muscleGroup")
public class MuscleGroupController {
    @Autowired
    private final MuscleGroupMapper muscleGroupMapper;
    private final MuscleGroupService muscleGroupService;
    private final ExerciseService exerciseService;
    @Autowired
    public MuscleGroupController(MuscleGroupMapper muscleGroupMapper, MuscleGroupService muscleGroupService, ExerciseService exerciseService) {
        this.muscleGroupMapper = muscleGroupMapper;
        this.muscleGroupService = muscleGroupService;
        this.exerciseService = exerciseService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<MuscleGroupWithoutExercisesDTO>> getFullMuscleGroup()
    {
        Iterable<MuscleGroup> muscleGroups = muscleGroupService.getAllMuscleGroup();
        List<MuscleGroupWithoutExercisesDTO> muscleGroupWithoutExercisesDTOS = StreamSupport.stream(muscleGroups.spliterator(), false)
                .map(muscleGroupMapper::toMuscleGroupWithoutExercises)
                .collect(Collectors.toList());
        return ResponseEntity.ok(muscleGroupWithoutExercisesDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MuscleGroupDTOWithExercises>> getByIdMuscleGroup(@PathVariable int id) {
        Optional<MuscleGroup> muscleGroup = muscleGroupService.getByIdMuscle(id);
        if (muscleGroup.isPresent()) {
            List<Exercise> exercises = (List<Exercise>) exerciseService.getAllExercisesInMuscleGroup(id);
            muscleGroup.get().setExercises(exercises);
        }
        return ResponseEntity.ok(muscleGroup.map(muscleGroupMapper::toMuscleGroupWithExercises));
    }
}
