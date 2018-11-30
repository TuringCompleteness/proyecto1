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

    private static String[] GuardiansOfTheGalaxy = {
            "Peter Quill", "Gamora", "Drax", "Groot", "Rocket",
    };

    private static String[] TheDefenders = {
            "Daredevil", "Jessica Jones", "Luke Cage",
    };

    private static String[] Inhumans = {
            "Black Bolt", "Medusa", "Karnak",
    };

    private static String[] Runaways = {
            "Alex Wilder", "Nico Minoru", "Karolina Dean",
    };

    private static String[] HeroesForHire = {
            "Iron Fist", "Luke Cage"
    };

    public static String[] getHeroes(String team) {
        switch (team) {
            case "Avengers":
                return Avengers;
            case "X Men":
                return Xmen;
            case "Fantastic Four":
                return FantasticFour;
            case "Guardians of The Galaxy":
                return GuardiansOfTheGalaxy;
            case "The Defenders":
                return TheDefenders;
            case "Inhumans":
                return Inhumans;
            case "Runaways":
                return Runaways;
            case "Heroes for Hire":
                return HeroesForHire;
            default:
                return new String[0];
        }
    }
}
