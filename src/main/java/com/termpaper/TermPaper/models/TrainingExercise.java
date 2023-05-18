package com.termpaper.TermPaper.models;

public class TrainingExercise {
    private int id;
    private int sets;
    private int repeats;
    private short restTime;
    private int exerciseId;
    private Exercise exercise;

    public TrainingExercise(int id, int sets, int repeats, short restTime, int exerciseId, Exercise exercise) {
        this.id = id;
        this.sets = sets;
        this.repeats = repeats;
        this.restTime = restTime;
        this.exerciseId = exerciseId;
        this.exercise = exercise;
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

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}