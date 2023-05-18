package com.termpaper.TermPaper.models;

import jakarta.persistence.*;
import java.util.Date;
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private int time;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "training_id")
    private TrainigPlan trainingPlan;
    public History(int id, Date date, int time, User user, TrainigPlan trainingPlan) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.user = user;
        this.trainingPlan = trainingPlan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TrainigPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainigPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }
}

