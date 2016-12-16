package com.example.mazonna.bubbly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void OnNewExam (View v){
        Intent i =  new Intent(this, NewExam.class);
        startActivity(i);
    }
    public void OnExams (View v){
        Intent i =  new Intent(getApplicationContext(), Exams.class);
        startActivity(i);
    }
}
