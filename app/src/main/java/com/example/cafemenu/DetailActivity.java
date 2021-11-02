package com.example.cafemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Detail Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", -1);

        ArrayList<Food> list = FoodData.getData(getApplicationContext());
        Food food = list.get(id);

        if (food != null) {
            TextView judulTV = findViewById(R.id.detail_judul);
            TextView hargaTV = findViewById(R.id.detail_harga);
            TextView deskripsiTV = findViewById(R.id.detail_deskripsi);
            ImageView image = findViewById(R.id.detail_photo);

            image.setImageDrawable(food.image);
            judulTV.setText(food.title);
            hargaTV.setText(String.valueOf(food.price));
            deskripsiTV.setText(food.description);
        }
    }
}