package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.quizapp", Context.MODE_PRIVATE);
       TextView greetingsView = findViewById(R.id.greetingsView);
       TextView finalScoreView = findViewById(R.id.finalScoreVIew);
        int score = sharedPreferences.getInt("score",0);

        String finalText ;
        if(score>=80) {
            finalText = "Awesome";
            greetingsView.setTextColor(Color.GREEN);
        }
        else if(score>=50){
            finalText = "Good job, keep going";
            greetingsView.setTextColor(Color.BLUE);

        }
        else {
            finalText = "You are getting there";
            greetingsView.setTextColor(Color.RED);

        }
        finalScoreView.setText(" " +score + " ");
        greetingsView.setText(finalText);





    }

    public void playAgain(View view) {
        Intent intent = new Intent(ResultActivity.this,MainActivity.class);
        startActivity(intent);
    }
}