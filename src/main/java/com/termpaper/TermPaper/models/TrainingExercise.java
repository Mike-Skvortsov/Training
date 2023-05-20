package com.termpaper.TermPaper.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "trainingExercises")
public class TrainingExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sets;
    private int repeats;
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
    public TrainingExercise(int id, int sets, int repeats, short restTime, Training training, Exercise exercise) {
        this.id = id;
        this.sets = sets;
        this.repeats = repeats;
        this.restTime = restTime;
        this.training = training;
        this.exercise = exercise;
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

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getRepeats() {
        return repeats;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public short getRestTime() {
        return restTime;
    }

    public void setRestTime(short restTime) {
        this.restTime = restTime;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}