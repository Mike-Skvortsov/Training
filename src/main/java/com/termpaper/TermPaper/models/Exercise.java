package com.termpaper.TermPaper.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Description is required")
    private String description;
    @NotBlank(message = "Image is required")
    private byte[] image;
    @JsonManagedReference
    @OneToOne(mappedBy = "exercise", fetch = FetchType.LAZY)
    private TrainingExercise trainingExercise;
    public Exercise()
    {

    }
    public Exercise(int id, String name, String description, byte[] image, TrainingExercise trainingExercise) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.trainingExercise = trainingExercise;
    }
    public TrainingExercise getTrainingExercise() {
        return trainingExercise;
    }

    public void setTrainingExercise(TrainingExercise trainingExercise) {
        this.trainingExercise = trainingExercise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}