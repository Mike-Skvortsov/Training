package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.trainingExerciseDTO.TrainingExerciseDTO;
import com.termpaper.TermPaper.models.TrainingExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ExerciseMapper.class)
public interface TrainingExerciseMapper {
    @Mapping(   source = "exercise", target = "exercise")
    TrainingExerciseDTO toTrainingExercise(TrainingExercise trainingExercise);
}
