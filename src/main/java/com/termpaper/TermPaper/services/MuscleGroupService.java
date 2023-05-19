package com.termpaper.TermPaper.services;

import com.termpaper.TermPaper.models.MuscleGroup;
import com.termpaper.TermPaper.repositories.MuscleGroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MuscleGroupService {
    private final MuscleGroupRepository muscleGroupRepository;
    public MuscleGroupService(MuscleGroupRepository muscleGroupRepository) {
        this.muscleGroupRepository = muscleGroupRepository;
    }
    public void create(MuscleGroup model)
    {
        muscleGroupRepository.save(model);
    }
    public Optional<MuscleGroup> getByIdMuscle(int id)
    {
        return muscleGroupRepository.findById(id);
    }
    public Iterable<MuscleGroup> getAllMuscleGroup()
    {
        return muscleGroupRepository.findAll();
    }
}
