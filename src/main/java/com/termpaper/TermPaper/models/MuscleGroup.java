package com.termpaper.TermPaper.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table (name = "muscleGroups")
public class MuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "cannot use more than 100 characters")
    private String title;
    @NotBlank(message = "Icon is required")
    @Size(max = 4000)
    private byte[] icon;
    @JsonIdentityReference(alwaysAsId = false)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "exercise_muscle_group",
            joinColumns = @JoinColumn(name = "muscle_group_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;
    public MuscleGroup(){}
    public MuscleGroup(int id, String title, byte[] icon, List<Exercise> exercises) {
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

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}