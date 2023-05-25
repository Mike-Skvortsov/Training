package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.trainingDTO.GetAllTrainingDTO;
import com.termpaper.TermPaper.DTO.trainingDTO.GetOneTrainingWithTrainingExercises;
import com.termpaper.TermPaper.DTO.trainingDTO.TrainingDTO;
import com.termpaper.TermPaper.models.Training;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TrainingExerciseMapper.class)
public interface TrainingMapper {
    TrainingDTO toTrainingDTOWithoutTrainingExercise(Training training);
    GetAllTrainingDTO toTrainingDTOWithoutOtherClasses(Training training);
    @Mapping(source = "trainingExercise", target = "trainingExercise", qualifiedByName = "toTrainingExercise")
    GetOneTrainingWithTrainingExercises toGetOneTrainingWithTrainingExercises(Training training);
}
