package com.hackaton.andrteam.alcoholdiary.data.model;

public class Advice {
    private String name;
    private int imageId;

    public Advice (String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    int getImageId() {
        return imageId;
    }
}