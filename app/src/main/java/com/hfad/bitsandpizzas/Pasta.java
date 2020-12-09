package com.hfad.bitsandpizzas;

import androidx.annotation.NonNull;

public class Pasta {

    private String name;
    private int imageRecourseId;

    public static final Pasta[] pastas = {
            new Pasta("Bolognese", R.drawable.bolognese),
            new Pasta("Carbonara", R.drawable.carbonara)
    };

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public int getImageRecourseId() {
        return imageRecourseId;
    }

    public Pasta(String name, int imageRecourseId) {
        this.name = name;
        this.imageRecourseId = imageRecourseId;
    }
}
