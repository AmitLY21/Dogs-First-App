package com.example.dogs.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dogs.R;

import java.util.ArrayList;

public class Activity_Main extends AppCompatActivity {

    private ArrayList<Integer> dogBreedsImages;
    private ImageView displayImg;

    private ArrayList<String> dogBreedName;
    private TextView breedName;
    private TextView scoreText;

    private Button btnLike;
    private Button btnDislike;

    private int index = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        initImages();
        initNames();


        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(true);
            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next(false);
            }
        });

    }

    private void findView() {
        btnLike = findViewById(R.id.panel_like);
        btnDislike = findViewById(R.id.panel_dislike);
        scoreText = (TextView) findViewById(R.id.score);
        breedName = (TextView) findViewById(R.id.panel_display_dog_breed);
        displayImg = findViewById(R.id.panel_display_img);

    }

    private void next(boolean flag) {
        if (index + 1 == dogBreedsImages.size()) {
            index = -1;
            score = 0;
        }
        if (flag == true) {
            score += 1;
            scoreText.setText(score + "");
            Toast.makeText(this, "❤", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "\uD83D\uDC4E", Toast.LENGTH_SHORT).show();
        }
        index += 1;
        breedName.setText(dogBreedName.get(index) + "");
        displayImg.setImageResource(dogBreedsImages.get(index));

    }

    private void initNames() {
        dogBreedName = new ArrayList<>();
        dogBreedName.add("Bulldog");
        dogBreedName.add("Beagle");
        dogBreedName.add("French Bulldog");
        dogBreedName.add("Golden Retriever");
        dogBreedName.add("French Poodle");
        dogBreedName.add("Pug");
        dogBreedName.add("Rottweiler");
        dogBreedName.add("Siberian Husky");
        dogBreedName.add("Shiba Inu");
        dogBreedName.add("Corgi");
    }

    private void initImages() {
        dogBreedsImages = new ArrayList<>();
        dogBreedsImages.add(R.drawable.bulldog_img);
        dogBreedsImages.add(R.drawable.beagle_img);
        dogBreedsImages.add(R.drawable.french_bulldog_img);
        dogBreedsImages.add(R.drawable.golden_retriever_img);
        dogBreedsImages.add(R.drawable.french_poodle_img);
        dogBreedsImages.add(R.drawable.pug_img);
        dogBreedsImages.add(R.drawable.rottweiler_img);
        dogBreedsImages.add(R.drawable.siberian_husky_img);
        dogBreedsImages.add(R.drawable.shiba_inu_img);
        dogBreedsImages.add(R.drawable.corgi_img);
    }
}