package com.termpaper.TermPaper.models;

import java.util.List;

public class TrainigPlan {
    private int id;
    private String name;
    private List<Training> trainigs;

    public TrainigPlan(int id, String name, List<Training> trainigs) {
        this.id = id;
        this.name = name;
        this.trainigs = trainigs;
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

    public List<Training> getTrainigs() {
        return trainigs;
    }

    public void setTrainigs(List<Training> trainigs) {
        this.trainigs = trainigs;
    }
}
