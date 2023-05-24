package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.exerciseDTO.ExerciseDTO;
import com.termpaper.TermPaper.models.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    ExerciseDTO toExerciseDTO(Exercise exercise);

}
