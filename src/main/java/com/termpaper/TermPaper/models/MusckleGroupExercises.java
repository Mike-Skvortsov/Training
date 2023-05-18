package com.termpaper.TermPaper.models;

public class MusckleGroupExercises {
    private int id;
    private int muscleGroupId;
    private int exerciseId;

    public MusckleGroupExercises(int id, int muscleGroupId, int exerciseId) {
        this.id = id;
        this.muscleGroupId = muscleGroupId;
        this.exerciseId = exerciseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMuscleGroupId() {
        return muscleGroupId;
    }

    public void setMuscleGroupId(int muscleGroupId) {
        this.muscleGroupId = muscleGroupId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }
}
