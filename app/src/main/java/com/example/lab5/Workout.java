package com.example.lab5;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("Liczby całkowite",
                    "byte\nshort\nint\nlong"),
            new Workout("Boolean",
                    "prawda\nfałsz"),
            new Workout("Znaki",
                    "char\nciąg znaków")
    };

    public Workout(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
