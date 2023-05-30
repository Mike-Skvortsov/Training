package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.trainingDTO.GetOneTrainingWithoutTrainingExercises;
import com.termpaper.TermPaper.DTO.trainingDTO.GetOneTrainingWithTrainingExercisesAndId;
import com.termpaper.TermPaper.DTO.trainingDTO.TrainingWithTrainingPlanDTO;
import com.termpaper.TermPaper.models.Training;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = TrainingExerciseMapper.class)
public interface TrainingMapper {
    GetOneTrainingWithoutTrainingExercises toTrainingDTOWithTrainingExercise(Training training);
    GetOneTrainingWithTrainingExercisesAndId toTrainingDTOWithTrainingExerciseAndId(Training training);
    TrainingWithTrainingPlanDTO toTrainingWithTrainingPlanDTO(Training training);

    Training toTraining(GetOneTrainingWithoutTrainingExercises training);
}
