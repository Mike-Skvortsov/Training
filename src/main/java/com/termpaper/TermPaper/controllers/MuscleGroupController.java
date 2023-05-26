package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.DTO.muscleGroupDTO.MuscleGroupWithoutExercisesDTO;
import com.termpaper.TermPaper.mappers.MuscleGroupMapper;
import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.services.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/muscleGroup")
public class MuscleGroupController {
    @Autowired
    private final MuscleGroupMapper muscleGroupMapper;
    private final MuscleGroupService muscleGroupService;
    @Autowired
    public MuscleGroupController(MuscleGroupMapper muscleGroupMapper, MuscleGroupService muscleGroupService) {
        this.muscleGroupMapper = muscleGroupMapper;
        this.muscleGroupService = muscleGroupService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<MuscleGroupWithoutExercisesDTO>> getFullMuscleGroup()
    {
        List<MuscleGroup> muscleGroups = (List<MuscleGroup>) muscleGroupService.getAllMuscleGroup();
        if (muscleGroups.isEmpty()) {
            throw new ExceptionController.ExerciseNotFoundException("Muscle group not found");
        }
        List<MuscleGroupWithoutExercisesDTO> muscleGroupWithoutExercisesDTOS = muscleGroups.stream()
                .map(muscleGroupMapper::toMuscleGroupWithoutExercises)
                .collect(Collectors.toList());
        return ResponseEntity.ok(muscleGroupWithoutExercisesDTOS);
    }
}
