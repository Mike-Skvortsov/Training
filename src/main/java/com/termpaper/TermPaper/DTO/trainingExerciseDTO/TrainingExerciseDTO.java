package com.termpaper.TermPaper.DTO.trainingExerciseDTO;

import com.termpaper.TermPaper.DTO.exerciseDTO.ExerciseDTO;

public class TrainingExerciseDTO {
    private Long id;
    private int sets;
    private int repeats;
    private short restTime;
    private ExerciseDTO exercise;

    public ExerciseDTO getExercise() {
        return exercise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExercise(ExerciseDTO exercise) {
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
}
