package com.termpaper.TermPaper.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String image;
    @ManyToMany
    private List<MuscleGroup> muscleGroup;
    @OneToOne(cascade = CascadeType.ALL)
    private TrainingExercise exercise;

    public Exercise(int id, String name, String description, String image, List<MuscleGroup> muscleGroup, TrainingExercise exercise) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.muscleGroup = muscleGroup;
        this.exercise = exercise;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<MuscleGroup> getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(List<MuscleGroup> muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public TrainingExercise getExercise() {
        return exercise;
    }

    public void setExercise(TrainingExercise exercise) {
        this.exercise = exercise;
    }
}