package com.termpaper.TermPaper.models;

import jakarta.persistence.ManyToMany;

import java.util.List;

public class TrainingPlan {
    private int id;
    private String name;
    @ManyToMany (mappedBy = "trainings")
    private List<Training> trainings;

    public TrainingPlan(int id, String name, List<Training> trainigs) {
        this.id = id;
        this.name = name;
        this.trainings = trainigs;
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

    public List<Training> getTrainigs() {
        return trainings;
    }

    public void setTrainigs(List<Training> trainigs) {
        this.trainings = trainigs;
    }
}
