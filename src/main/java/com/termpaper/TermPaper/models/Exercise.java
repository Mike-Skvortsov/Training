package com.termpaper.TermPaper.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank (message = "name is required")
    @Size(max = 100, message = "cannot use more than 100 characters")
    private String name;
    @NotBlank (message = "description is required")
    @Size(max = 1000, message = "cannot use more than 1000 characters")
    private String description;
    @NotBlank(message = "image is required")
    private byte[] image;
    @JsonIdentityReference(alwaysAsId = false)
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