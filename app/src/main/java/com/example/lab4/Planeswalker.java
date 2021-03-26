package com.example.lab4;

public class Planeswalker {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Planeswalker[] planeswalkers = {
            new Planeswalker("Liliana Vess",
                    "Human planeswalker from Dominaria and is both a master necromancer" +
                            " and a healer.",
                    R.drawable.liliana),
            new Planeswalker("Nicol Bolas",
                    "The now nameless planeswalker once named Nicol Bolas (born as just Nicol), is the youngest" +
                            " and most infamous of the seven Elder Dragons to have survived the Elder Dragon War.",
                    R.drawable.bolas),
            new Planeswalker("Gideon Jura",
                    "He was a hieromancer and planeswalker beholden to the " +
                            "multiplanar coalition known as the Gatewatch. Affectionately called Gids by " +
                            "Chandra Nalaar and called Beefslab by Liliana Vess. ",
                    R.drawable.gideon)
    };

    private Planeswalker(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
