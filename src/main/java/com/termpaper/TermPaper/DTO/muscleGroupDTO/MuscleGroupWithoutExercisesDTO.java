package com.termpaper.TermPaper.DTO.muscleGroupDTO;

public class MuscleGroupWithoutExercisesDTO {
    private int id;
    private String title;
    private byte[] icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }
}
