package com.completeness.turing.heroescatalogue.GraphicModels;

public class TeamCharacters {

    private static String[] Avengers = {
      "Iron Man", "Captain America", "Spider-Man", "Thor",
    };

    private static String[] Xmen = {
            "Wolverine", "Professor X", "Storm", "Cyclops", "Gambit", "Beast"
    };

    private static String[] FantasticFour = {
            "Mr. Fantastic", "Sue Storm", "Johnny Storm", "The Thing",
    };

    public static String[] getHeroes(String team) {
        switch (team) {
            case "Avengers":
                return Avengers;
            case "X Men":
                return Xmen;
            case "Fantastic Four":
                return FantasticFour;
            default:
                return new String[0];
        }
    }
}
