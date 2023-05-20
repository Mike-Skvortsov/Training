package com.termpaper.TermPaper.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table (name = "muscleGroups")
public class MuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String icon;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "exercise_muscle_group",
            joinColumns = @JoinColumn(name = "muscle_group_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;
    public MuscleGroup(){}
    public MuscleGroup(int id, String title, String icon) {
        this.id = id;
        this.title = title;
        this.icon = icon;
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