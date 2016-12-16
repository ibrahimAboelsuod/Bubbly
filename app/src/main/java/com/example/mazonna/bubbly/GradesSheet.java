package com.example.mazonna.bubbly;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class GradesSheet extends AppCompatActivity {

    String[] names = {"Ahmed","Amanda","Mahmoud","Fathy", "Madonna", "Ibrahim"};
    int[] grades = {12,15,17,18, 20, 19};
    TableLayout grades_table ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_sheet);
        fill_table();
    }
    private void fill_table() {
        grades_table=(TableLayout)findViewById(R.id.grades_table);
        for(int i =0 ; i<20 ; i++)
        {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams());
            TextView name = new TextView(this);
            name.setText((1+i)+"- "+names[i%6]+"         ");
            name.setTextSize(20);
            TextView grade = new TextView(this);
            grade.setText(Integer.toString(grades[i%6])+"         ");
            grade.setTextSize(20);
            Button edit_but = new Button(this);
            edit_but.setText("Edit");
            row.addView(name);
            row.addView(grade);
            row.addView(edit_but);
            if(i%2 !=0) {
                row.setBackgroundColor(Color.parseColor("#ffcecece"));
            }
            grades_table.addView(row);
        }
    }
    public void onSave (View v){
        Intent i =  new Intent(getApplicationContext(), Exams.class);
        startActivity(i);
    }
}
