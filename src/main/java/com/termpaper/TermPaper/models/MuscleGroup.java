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
    @JoinTable(
            name = "exercise_muscleGroup",
            joinColumns = @JoinColumn(name = "muscleGroup_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;
    public MuscleGroup(){}
    public MuscleGroup(int id, String title, String icon, List<Exercise> exercises) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.exercises = exercises;
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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}