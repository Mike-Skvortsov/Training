package com.termpaper.TermPaper.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "trainings")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "name is required!")
    @Size(min = 50, max = 500, message = "cannot use more than 500 or less than 50 characters!")
    private String name;
    @Size(max = 1000, message = ("cannot use more than 1000 characters!"))
    private String description;
    @Min(value = 1, message = "time cannot be less than 0!")
    private int time;
    @Column(name = "kcal")
    @Min(value = 1, message = "KCal should be greater than 0!")
    private int KCal;
    @Min(value = 0, message = "Progress should be greater than 0!")
    private int progress;
    @JsonIdentityReference(alwaysAsId = false)
    @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<TrainingExercise> trainingExercises;

    @JsonIdentityReference(alwaysAsId = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainingPlan_id")
    private TrainingPlan trainingPlan;
    public Training(){}

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public int getKCal() {
        return KCal;
    }

    public void setKCal(int KCal) {
        this.KCal = KCal;
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


    public List<TrainingExercise> getTrainingExercises() {
        return trainingExercises;
    }

    public void setTrainingExercises(List<TrainingExercise> trainingExercises) {
        this.trainingExercises = trainingExercises;
    }
}