package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);  // Set the intro layout

        // Find the TextView that will display the loading text
        TextView loadingText = findViewById(R.id.loadingText);

        // Load the rotate animation
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        // Start the animation on the TextView
        loadingText.startAnimation(rotateAnimation);

        // Delay transition to the next activity for 5 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Transition to the next activity (replace NextActivity with your actual next activity)
                Intent intent = new Intent(intro.this, food_item.class);
                startActivity(intent);
                finish(); // Close the intro activity so the user cannot go back to it
            }
        }, 4000); // Delay of 5000 milliseconds (5 seconds)
    }
}