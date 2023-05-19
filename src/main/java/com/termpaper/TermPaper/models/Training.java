package com.termpaper.TermPaper.models;

import jakarta.persistence.*;

@Entity
@Table (name = "trainings")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String name;
    private String description;
    private int time;
    private int progress;
    private boolean isActive;
    @OneToMany(mappedBy = "trainings")
    private TrainingExercise trainingExercise;
    public Training(int id, int progress, int time, String descriprion, String name, boolean isActive, TrainingExercise trainingExercise)
    {

        this.id = id;
        this.progress = progress;
        this.time = time;
        this.description = descriprion;
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

    public TrainingExercise getTrainingExercise() {
        return trainingExercise;
    }

    public void setTrainingExercise(TrainingExercise trainingExercise) {
        this.trainingExercise = trainingExercise;
    }
}
