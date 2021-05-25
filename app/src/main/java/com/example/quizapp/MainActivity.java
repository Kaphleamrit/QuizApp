package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> questions;
    ArrayList<String> answers;
    ArrayList<ArrayList<String>> options;
    int noOfQuestions = 9;
    TextView questionView;
    TextView pageView;
    TextView scoreView;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    int counter = 1;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.btnView0);
        b2 =(Button) findViewById(R.id.btnView1);
        b3 = (Button) findViewById(R.id.btnView2);
        b4 =(Button) findViewById(R.id.btnView3);
        questionView = findViewById(R.id.textView);
        pageView = findViewById(R.id.pageView);
        scoreView = findViewById(R.id.scoreView);
         questions = new ArrayList<>();
         answers = new ArrayList<>();
         options = new ArrayList<>();

        questions.add("Finding the location of the element with a given value is:");
        answers.add("Search");
        options.add(new ArrayList<>(Arrays.asList("Traversal","Search","Sort","None of the above")));

        questions.add(" The complexity of Binary search algorithm is ");
        answers.add("O(logn)");
        options.add(new ArrayList<>(Arrays.asList("O(n)","O(logn)","O(n^1)","O(nlogn)")));

        questions.add("The operation of processing each element in the list is known as ");
        answers.add("Traversal");
        options.add(new ArrayList<>(Arrays.asList("Sorting","Merging","Inserting","Traversal")));

        questions.add("The complexity of merge sort algorithm is ");
        answers.add("O(nlogn)");
        options.add(new ArrayList<>(Arrays.asList("O(n)", "O(log n)","O(n^1)","O(nlogn)")));

        questions.add("Which of the following case does not exist in complexity theory ");
        answers.add("Null case");
        options.add(new ArrayList<>(Arrays.asList("Best case","Worst case","Average case","Null case")));

        questions.add("A ________ is a special Tree-based data structure in which the tree is a complete binary tree.?");
        answers.add("Heap");
        options.add(new ArrayList<>(Arrays.asList("Graph", "Heap", "List", "Stack")));

        questions.add("How do the nested calls of the function get managed?");
        answers.add("Through Stacks");
        options.add(new ArrayList<>(Arrays.asList("Through Queues","Through Stacks","Through Trees","Through Graphs")));

        questions.add(" What is combining the records in two different sorted files into a single sorted file?");
        answers.add("Merging");
        options.add(new ArrayList<>(Arrays.asList("Sorting","Searching","Listing","Merging")));

        questions.add("In order traversal of binary search tree will produce:");
        answers.add("sorted list");
        options.add(new ArrayList<>(Arrays.asList("unsorted list","sorted list","reverse of input","none of these")));

        questions.add("Which of the following data structure is linear data structure?");
        answers.add("Array");
        options.add(new ArrayList<>(Arrays.asList("Tree","Graph","Array","Linked list")));

        questions.add("Which of the following data structure is linear data structure?");
        answers.add("Array");
        options.add(new ArrayList<>(Arrays.asList("Tree","Graph","Array","Linked list")));

        questionView.setText(questions.get(0));
        b1.setText(options.get(0).get(0));
        b2.setText(options.get(0).get(1));
        b3.setText(options.get(0).get(2));
        b4.setText(options.get(0).get(3));


    }

     public void handleClick(View view) {

        Button clickBtn = (Button) view;
        String clickedAns = clickBtn.getText().toString();
         if(answers.get(counter-1).equals(clickedAns)) {
            score+=10;
            scoreView.setText("Score: " + score);
        }
        counter++;
        if(counter == 11) {
            SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.quizapp", Context.MODE_PRIVATE);
            sharedPreferences.edit().putInt("score",score).apply();
             Intent intent = new Intent(MainActivity.this,ResultActivity.class);
             startActivity(intent);
         }
        pageView.setText(counter+"/10");

        questionView.setText(questions.get(counter-1));
        b1.setText(options.get(counter-1).get(0));
         b2.setText(options.get(counter-1).get(1));
         b3.setText(options.get(counter-1).get(2));
         b4.setText(options.get(counter-1).get(3));


    }

}