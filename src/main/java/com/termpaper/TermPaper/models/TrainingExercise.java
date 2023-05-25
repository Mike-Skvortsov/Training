package com.termpaper.TermPaper.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "trainingExercises")
public class TrainingExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Min(value = 1, message = "Sets should be greater than 0")
    private int sets;
    @Min(value = 1, message = "Repeats should be greater than 0")
    private int repeats;
    @Min(value = 1, message = "Rest time should be greater than 0")
    private short restTime;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id")
    private Training training;

    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    public TrainingExercise()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSets() {
        return sets;
    }

    public int getRepeats() {
        return repeats;
    }

    public short getRestTime() {
        return restTime;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Training getTraining() {
        return training;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public void setRestTime(short restTime) {
        this.restTime = restTime;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}