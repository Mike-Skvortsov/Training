package com.termpaper.TermPaper.DTO.muscleGroupDTO;

import com.termpaper.TermPaper.DTO.exerciseDTO.ExerciseDTO;
import com.termpaper.TermPaper.models.Exercise;

import java.util.List;

public class MuscleGroupDTOWithExercises {
    private int id;
    private String title;
    private byte[] icon;
    private List<ExerciseDTO> exercises;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public List<ExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseDTO> exercises) {
        this.exercises = exercises;
    }
}
