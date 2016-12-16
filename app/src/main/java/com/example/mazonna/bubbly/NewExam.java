package com.example.mazonna.bubbly;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewExam extends AppCompatActivity {

    public static final int request_capture =1;
    ImageView result_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exam);
        Button click = (Button) findViewById(R.id.btnAddScan);
        result_photo= (ImageView)findViewById(R.id.imageView);
        if(!hasCamera())
        {
            click.setEnabled(false);
        }
    }
    public boolean hasCamera()
    {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }
    public void lanchCamera(View v)
    {
        Intent i = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, request_capture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == request_capture && resultCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap photo =(Bitmap)extras.get("data");
            result_photo.setImageBitmap(photo);
        }
    }

    public void onCorrect (View v) {
        EditText ed = (EditText) findViewById(R.id.edtxtSubjectName);
        String S = ed.getText().toString();
        if (S.matches("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter Subject name", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent i = new Intent(getApplicationContext(), GradesSheet.class);
            startActivity(i);
        }
    }

    private static final int EDIT_REQUEST_CODE = 44;

    public void onSet (View v){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        startActivityForResult(intent, EDIT_REQUEST_CODE);
    }

}
