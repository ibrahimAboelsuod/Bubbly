package com.example.mazonna.bubbly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Exams extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);
    }
    public void on_click (View v){
        Intent i =  new Intent(getApplicationContext(), GradesSheet.class);
        startActivity(i);
    }
}
