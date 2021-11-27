package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    TextView questionText, scoreText;

    int score = 0;
    int index = 0;
    List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        questionText = findViewById(R.id.question);
        scoreText = findViewById(R.id.score);

        questions.add(new Question(
                "Столица Англии?",
                new String[]{"Лондон", "Вашингон", "Москва", "Токио"},
                "Лондон"
        ));
        questions.add(new Question(
                "Столица Италии?",
                new String[]{"Рим", "Париж", "Берлин", "Киев"},
                "Рим"
        ));

        setScore();
        setQuestion();
        setVariants();

        button1.setOnClickListener((view -> {
            checkAnswer(questions.get(index).variants[0]);
        }));
        button2.setOnClickListener((view -> {
            checkAnswer(questions.get(index).variants[1]);
        }));
        button3.setOnClickListener((view -> {
            checkAnswer(questions.get(index).variants[2]);
        }));
        button4.setOnClickListener((view -> {
            checkAnswer(questions.get(index).variants[3]);
        }));
    }

    public void setScore() {
        scoreText.setText("Очков: " + score);
    }

    public void setQuestion() {
        questionText.setText(questions.get(index).question);
    }

    public void setVariants() {
        String[] variants = questions.get(index).variants;
        button1.setText(variants[0]);
        button2.setText(variants[1]);
        button3.setText(variants[2]);
        button4.setText(variants[3]);
    }

    public void checkAnswer(String answer) {
        if (questions.get(index).rightAnswer.equals(answer)) {
            score++;
            Toast.makeText(
                    this,
                    "Вы ответили правильно",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Toast.makeText(
                    this,
                    "Вы ответили неправильно",
                    Toast.LENGTH_SHORT
            ).show();
        }
        index++;
        if (questions.size() <= index) {
            Toast.makeText(
                    this,
                    "Вопросы закочились! У вас " + score + " очков",
                    Toast.LENGTH_SHORT
            ).show();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            setQuestion();
            setVariants();
            setScore();
        }
    }
}