package com.termpaper.TermPaper.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table (name = "trainingPlans")
public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "trainingPlan_training",
            joinColumns = @JoinColumn(name = "trainingPlan_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id")
    )
    private List<Training> trainings;
    public TrainingPlan(){}

    public TrainingPlan(int id, String name, List<Training> trainings) {
        this.id = id;
        this.name = name;
        this.trainings = trainings;
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

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
