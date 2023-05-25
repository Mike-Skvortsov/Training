package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.trainingDTO.GetOneTrainingWithTrainingExercises;
import com.termpaper.TermPaper.models.Training;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = TrainingExerciseMapper.class)
public interface TrainingMapper {
    GetOneTrainingWithTrainingExercises toTrainingDTOWithTrainingExercise(Training training);

}
