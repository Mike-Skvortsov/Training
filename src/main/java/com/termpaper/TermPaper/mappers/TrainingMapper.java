package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.trainingDTO.TrainingDTO;
import com.termpaper.TermPaper.models.Training;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingMapper {
    TrainingDTO toTrainingDTOWithoutTrainingExercise(Training training);
}
