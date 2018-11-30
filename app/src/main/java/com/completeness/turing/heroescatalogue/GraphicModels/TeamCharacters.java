package com.completeness.turing.heroescatalogue.GraphicModels;

public class TeamCharacters {

    private static String[] Avengers = {
      "Iron Man", "Captain America", "Spider-Man", "Thor", "Hulk", "Hawkeye", "Black Panther",
            "Scarlet Witch", "Vision", "Doctor Strange",
    };

    private static String[] Xmen = {
            "Wolverine", "Professor X", "Storm", "Cyclops", "Gambit", "Beast", "Jean Grey",
            "Kitty Pryde", "Colossus", "Nightcrawler", "Magneto"
    };

    private static String[] FantasticFour = {
            "Mr. Fantastic", "Sue Storm", "Human Torch", "Thing",
    };

    private static String[] GuardiansOfTheGalaxy = {
            "Peter Quill", "Gamora", "Drax", "Groot", "Rocket", "Adam Warlock"
    };

    private static String[] TheDefenders = {
            "Daredevil", "Jessica Jones", "Luke Cage", "Danny Rand",
    };

    private static String[] Inhumans = {
            "Black Bolt", "Medusa", "Karnak", "Crystal", "Gorgon", "Triton", "Maximus"
    };

    private static String[] Runaways = {
            "Alex Wilder", "Nico Minoru", "Karolina Dean", "Chase Stein", "Molly Hayes", "Gertrude Yorkes"
    };

    private static String[] HeroesForHire = {
            "Danny Rand", "Luke Cage"
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
