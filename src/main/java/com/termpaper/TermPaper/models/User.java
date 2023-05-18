package com.termpaper.TermPaper.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String userName;
    private String email;
    private Genre genre;
    private int age;
    private float height;
    private float weight;
    @OneToMany(mappedBy = "user")
    private List<History> histories;
    public User(String userName, String email, Genre genre, int age, float height, float weight)
    {
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.genre = genre;
        this.height = height;
        this.weight = weight;
    }
    public String getEmail()
    {
        return email;
    }
    public String getUserName()
    {
        return userName;
    }
    public float getWeight()
    {
        return weight;
    }
    public int getAge()
    {
        return age;
    }
    public Genre getGenre()
    {
        return genre;
    }
    // Додаткові методи для встановлення значень полів
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }
        this.age = age;
    }

    public void setHeight(float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be a positive number.");
        }
        this.height = height;
    }

    public void setWeight(float weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be a positive number.");
        }
        this.weight = weight;
    }
}
