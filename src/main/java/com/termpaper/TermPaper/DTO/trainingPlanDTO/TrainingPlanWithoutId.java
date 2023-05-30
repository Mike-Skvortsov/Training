package com.termpaper.TermPaper.DTO.trainingPlanDTO;

import com.termpaper.TermPaper.DTO.trainingDTO.GetOneTrainingWithTrainingExercises;

import java.util.List;

public class TrainingPlanWithoutId {
        private String name;
        private String description;
        private byte[] image;
        private List<GetOneTrainingWithTrainingExercises> trainings;

    public List<GetOneTrainingWithTrainingExercises> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<GetOneTrainingWithTrainingExercises> trainings) {
        this.trainings = trainings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}