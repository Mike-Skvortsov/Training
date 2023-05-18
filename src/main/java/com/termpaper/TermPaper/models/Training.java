package com.termpaper.TermPaper.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String name;
    private String descriprion;
    private int time;
    private int progress;
    private boolean isActive;
    private int trainingExerciseId;
    private TrainingExercise trainingExercise;
    public Training(int id, int trainingExerciseId, int progress, int time, String descriprion, String name, boolean isActive, TrainingExercise trainingExercise)
    {

        this.id = id;
        this.trainingExerciseId = trainingExerciseId;
        this.progress = progress;
        this.time = time;
        this.descriprion = descriprion;
        this.name = name;
        this.isActive = isActive;
        this.trainingExercise = trainingExercise;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getTrainingExerciseId() {
        return trainingExerciseId;
    }

    public void setTrainingExerciseId(int trainingExerciseId) {
        this.trainingExerciseId = trainingExerciseId;
    }

    public TrainingExercise getTrainingExercise() {
        return trainingExercise;
    }

    public void setTrainingExercise(TrainingExercise trainingExercise) {
        this.trainingExercise = trainingExercise;
    }
}
