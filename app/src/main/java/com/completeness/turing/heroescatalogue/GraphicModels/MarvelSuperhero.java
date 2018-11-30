package com.completeness.turing.heroescatalogue.GraphicModels;

public class MarvelSuperhero {

    private int picture;
    private String name;
    private String description = "Lo sentimos, este héroe no tiene información, quizá está en un " +
            "archivo secreto de S.H.I.E.L.D";
    private String marvelPicture;

    public MarvelSuperhero(int picture, String name, String description, String marvelPicture) {
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.marvelPicture = marvelPicture;
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
        if (description == ""){
            this.description = "Lo sentimos, este héroe no tiene información, quizá está en un " +
                    "archivo secreto de S.H.I.E.L.D";
        } else {
            this.description = description;
        }

    }

    public String getMarvelPicture() {
        return marvelPicture;
    }

    public void setMarvelPicture(String marvelPicture) {
        this.marvelPicture = marvelPicture;
    }
}
