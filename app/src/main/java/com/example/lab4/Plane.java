package com.example.lab4;

public class Plane {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Plane[] planes = {
            new Plane("Dominaria",
                    "Dominaria is a plane whose name means \"Song of Dominia\". Nicol Bolas once claimed that he had coined this name himself." +
                            " Dominaria was the Nexus of the Multiverse before the Mending. It is the setting for the majority of Magic storylines.",
                    R.drawable.dominaria),
            new Plane("Innistrad",
                    "Innistrad is a plane. It takes its inspiration from Gothic fiction set in 18th and 19th century North Eastern Europe. ",
                    R.drawable.innistrad),
            new Plane("Ravnica",
                    "Ravnica is a plane whose main planet is covered in a large city, known as Ravnica. It takes its flavor from that" +
                            " of Eastern Europe. Ravnica is the setting of the Ravnica block, Return to Ravnica block and Guilds of Ravnica, Ravnica " +
                            "Allegiance, and War of the Spark expansions.",
                    R.drawable.ravnica),
    };

    private Plane(String name, String description, int imageResourceId){
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
