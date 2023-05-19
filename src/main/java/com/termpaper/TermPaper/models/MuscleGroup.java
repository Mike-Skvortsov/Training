package com.termpaper.TermPaper.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "muscleGroups")
public class MuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String icon;
    @ManyToMany
    private List<Exercise> exercise;

    public MuscleGroup(int id, String title, String icon, Exercise exercise, List<Exercise> exercise1) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.exercise = exercise1;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Exercise> getExercise() {
        return exercise;
    }

    public void setExercise(List<Exercise> exercise) {
        this.exercise = exercise;
    }
}