package com.termpaper.TermPaper.DTO.historyDTO;

import com.termpaper.TermPaper.DTO.trainingDTO.TrainingDTO;
import com.termpaper.TermPaper.DTO.trainingDTO.TrainingWithTrainingPlanDTO;
import com.termpaper.TermPaper.DTO.trainingPlanDTO.TrainingPlanGetAllDTO;

import java.util.Date;

public class HistoryWithoutUserDTO {
    private int id;
    private Date date;
    private int time;
    private TrainingWithTrainingPlanDTO training;

    public TrainingWithTrainingPlanDTO getTraining() {
        return training;
    }

    public void setTraining(TrainingWithTrainingPlanDTO training) {
        this.training = training;
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

}
