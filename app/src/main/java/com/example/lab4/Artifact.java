package com.example.lab4;

public class Artifact {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Artifact[] artifacts = {
            new Artifact("Chain Veil",
                    "It was created to turn someone into a vessel for the resurrection of the long-dead Onakke." +
                            " It kills its users if they're not strong enough. Others, like Ob Nixilis, are turned into a demon." +
                            " It masks the wearer's soul from those who would take it.",
                    R.drawable.chain_veil),
            new Artifact("Immortal Sun",
                    "The Immortal Sun is rumored to be more valuable and powerful than any other artifact in existence," +
                            " promising boundless wealth, the strength of the empire, command over nature, and eternal life. The history of the Immortal Sun is a history of its misuse by mortals.",
                    R.drawable.immortal_sun),
            new Artifact("Sword of the Realms",
                    "The Sword of the Realms is a weapon from Kaldheim created from tyrite by the god Halvar. It is capable of cutting through the Cosmos itself. ",
                    R.drawable.sword),
    };

    private Artifact(String name, String description, int imageResourceId){
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
