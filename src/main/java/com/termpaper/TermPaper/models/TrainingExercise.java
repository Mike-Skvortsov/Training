package com.termpaper.TermPaper.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "trainingExercises")
public class TrainingExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int sets;
    private int repeats;
    private short restTime;
    @OneToMany(mappedBy = "trainingExercises")
    private List<Exercise> exercises;

    public TrainingExercise(int id, int sets, int repeats, short restTime, List<Exercise> exercises) {
        this.id = id;
        this.sets = sets;
        this.repeats = repeats;
        this.restTime = restTime;
        this.exercises = exercises;
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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}