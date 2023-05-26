package com.termpaper.TermPaper.DTO.trainingDTO;

public class GetAllTrainingDTO {
    private int id;
    private String name;
    private String description;
    private int time;
    private int KCal;
    private int progress;

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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getKCal() {
        return KCal;
    }

    public void setKCal(int KCal) {
        this.KCal = KCal;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
