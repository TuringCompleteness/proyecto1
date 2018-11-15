package com.completeness.turing.heroescatalogue;

public class TeamCharacters {

    private static String[] theAvengers = {
      "Iron Man", "Captain America", "Spider-Man", "Thor",
    };

    public static String[] getHeroes(String team) {
        switch (team) {
            case "Avengers":
                return theAvengers;
            default:
                return new String[0];
        }
    }
}
