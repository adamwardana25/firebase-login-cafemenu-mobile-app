package com.example.cafemenu;

import android.graphics.drawable.Drawable;

public class Food {
    String title;
    String description;
    int price;
    Drawable image;

    Food(String title, String description, int price, Drawable image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }
}
