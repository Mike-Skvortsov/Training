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
    @ManyToMany(mappedBy = "exercises")
    private List<MuscleGroup> muscleGroups;
    @OneToOne(mappedBy = "exercise")
    private TrainingExercise trainingExercise;
    public Exercise()
    {

    }
    public Exercise(int id, String name, String description, String image, List<MuscleGroup> muscleGroups, TrainingExercise trainingExercise) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.muscleGroups = muscleGroups;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<MuscleGroup> getMuscleGroups() {
        return muscleGroups;
    }

    public void setMuscleGroups(List<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    public TrainingExercise getTrainingExercise() {
        return trainingExercise;
    }

    public void setTrainingExercise(TrainingExercise trainingExercise) {
        this.trainingExercise = trainingExercise;
    }
}