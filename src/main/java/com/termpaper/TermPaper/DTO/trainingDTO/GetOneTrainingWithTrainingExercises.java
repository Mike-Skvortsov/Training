package com.termpaper.TermPaper.DTO.trainingDTO;

import com.termpaper.TermPaper.models.TrainingExercise;

import java.util.List;

public class GetOneTrainingWithTrainingExercises {
    private String name;
    private String description;
    private int time;
    private int KCal;
    private int progress;
    private boolean isDone;
    private List<TrainingExercise> trainingExercises;

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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getKCal() {
        return KCal;
    }

    public void setKCal(int KCal) {
        this.KCal = KCal;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public List<TrainingExercise> getTrainingExercises() {
        return trainingExercises;
    }

    public void setTrainingExercises(List<TrainingExercise> trainingExercises) {
        this.trainingExercises = trainingExercises;
    }
}
