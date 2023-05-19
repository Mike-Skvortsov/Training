package com.termpaper.TermPaper.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String email;
    private final Genre genre;
    private int age;
    private float height;
    private float weight;
    @OneToMany(mappedBy = "users")
    private List<History> histories;

    public User(int id, String userName, String email, Genre genre, int age, float height, float weight, List<History> histories) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.genre = genre;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.histories = histories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }
}