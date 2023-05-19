package com.termpaper.TermPaper.controllers;

import com.termpaper.TermPaper.models.Exercise;
import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.services.MuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/muscleGroup")
public class MuscleGroupController {
    private final MuscleGroupService muscleGroupService;
    @Autowired
    public MuscleGroupController(MuscleGroupService muscleGroupService) {
        this.muscleGroupService = muscleGroupService;
    }
    @GetMapping("/all")
    public Iterable<MuscleGroup> getFullMuscleGroup()
    {
        return muscleGroupService.getAllMuscleGroup();
    }
    @GetMapping("/{id}")
    public Optional<MuscleGroup> getByIdMuscleGroup(@PathVariable int id)
    {
        Optional<MuscleGroup> muscleGroup = muscleGroupService.getByIdMuscle(id);
        if (muscleGroup.isPresent()) {
            List<Exercise> exercises = muscleGroup.get().getExercises();
            muscleGroup.get().setExercises(exercises);
        }
        return muscleGroup;
    }
    @PostMapping("/create")
    public int CreateMuscleGroup(MuscleGroup model)
    {
        muscleGroupService.create(model);
        return model.getId();
    }
}
