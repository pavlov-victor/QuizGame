package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView scorePoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scorePoints = findViewById(R.id.score_points);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        scorePoints.setText("очков: " + score);
    }
}