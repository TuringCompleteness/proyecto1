package com.completeness.turing.heroescatalogue.GraphicModels;

public class MarvelTeam {

    private String teamName;
    private String creators;
    private int color;
    private int teamPicture;

    public MarvelTeam(int teamPicture, String teamName, String creators, int color) {
        this.teamName = teamName;
        this.teamPicture = teamPicture;
        this.creators = creators;
        this.color = color;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamPicture() {
        return teamPicture;
    }

    public void setTeamPicture(int teamPicture) {
        this.teamPicture = teamPicture;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
