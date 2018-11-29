package com.completeness.turing.heroescatalogue.GraphicModels;

public class MarvelSuperhero {

    private int picture;
    private String name;
    private String description;

    public MarvelSuperhero(int picture, String name, String description) {
        this.picture = picture;
        this.name = name;
        this.description = description;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
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
}
