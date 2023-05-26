package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.trainingDTO.TrainingWithTrainingPlanDTO;
import com.termpaper.TermPaper.DTO.trainingPlanDTO.TrainingPlanGetAllDTO;
import com.termpaper.TermPaper.DTO.trainingPlanDTO.TrainingPlanWithoutId;
import com.termpaper.TermPaper.models.TrainingPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingPlanMapper {
    @Mapping(target = "trainings", ignore = true)
    TrainingPlanWithoutId toDTOWithoutTrainings(TrainingPlan trainingPlan);
    TrainingPlanWithoutId toDTOWithTrainings(TrainingPlan trainingPlan);

    TrainingPlanGetAllDTO toGetAllWithIdDTO(TrainingPlan trainingPlan);
    TrainingWithTrainingPlanDTO toTrainingWithTrainingPlanDTO(TrainingPlan trainingPlan);
    TrainingPlan toEntity(TrainingPlanWithoutId trainingPlanDTO);
}
