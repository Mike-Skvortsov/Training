package com.termpaper.TermPaper.mappers;

import com.termpaper.TermPaper.DTO.trainingExerciseDTO.TrainingExerciseDTO;
import com.termpaper.TermPaper.DTO.trainingExerciseDTO.TrainingExerciseDTOWithoutTrainingAndExercise;
import com.termpaper.TermPaper.models.TrainingExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ExerciseMapper.class)
public interface TrainingExerciseMapper {
    @Mapping(source = "exercise", target = "exercise", qualifiedByName = "toExerciseDTO")
    TrainingExerciseDTO toTrainingExercise(TrainingExercise trainingExercise);

    TrainingExerciseDTOWithoutTrainingAndExercise toTrainingExerciseDTOWithoutTrainingAndExercise(TrainingExercise trainingExercise);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "training", ignore = true)
    @Mapping(target = "exercise", ignore = true)
    @Mapping(target = "sets", source = "model.sets")
    @Mapping(target = "repeats", source = "model.repeats")
    @Mapping(target = "restTime", source = "model.restTime")
    TrainingExercise toTrainingExercise(TrainingExerciseDTOWithoutTrainingAndExercise model);
}
