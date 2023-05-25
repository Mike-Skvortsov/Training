package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.exerciseDTO.ExerciseDTO;
import com.termpaper.TermPaper.models.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    @Named("toExerciseDTO")
    ExerciseDTO toExerciseDTO(Exercise exercise);

    @Named("toExercise")
    Exercise toExercise(ExerciseDTO exerciseDTO);
}
