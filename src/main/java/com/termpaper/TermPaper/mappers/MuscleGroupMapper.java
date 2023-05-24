package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.muscleGroupDTO.MuscleGroupDTOWithExercises;
import com.termpaper.TermPaper.DTO.muscleGroupDTO.MuscleGroupWithoutExercisesDTO;
import com.termpaper.TermPaper.models.MuscleGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MuscleGroupMapper {
    MuscleGroupWithoutExercisesDTO toMuscleGroupWithoutExercises(MuscleGroup muscleGroup);
    MuscleGroupDTOWithExercises toMuscleGroupWithExercises(MuscleGroup muscleGroup);
}
