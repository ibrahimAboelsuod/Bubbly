package com.example.mazonna.bubbly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edtxtLoginUsername, edtxtLoginPassword;
    TextView txtLoginUsername, txtLoginPassword;
    int fadeDuration = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtLoginUsername = (TextView)findViewById(R.id.txtLoginUsername);
        edtxtLoginUsername = (EditText)findViewById(R.id.edtxtLoginUsername);

        txtLoginPassword = (TextView)findViewById(R.id.txtLoginPassword);
        edtxtLoginPassword = (EditText)findViewById(R.id.edtxtLoginPassword);


        edtxtLoginUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edtxtLoginUsername.getText().length() > 0 && txtLoginUsername.getAlpha()>= 0)
                    txtLoginUsername.animate().alpha(1f).setDuration(fadeDuration);
                else if(edtxtLoginUsername.getText().length() == 0 && txtLoginUsername.getAlpha()<= 1)
                    txtLoginUsername.animate().alpha(0f).setDuration(fadeDuration);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtxtLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edtxtLoginPassword.getText().length() > 0 && txtLoginPassword.getAlpha()>= 0)
                    txtLoginPassword.animate().alpha(1f).setDuration(fadeDuration);
                else if(edtxtLoginUsername.getText().length() == 0 && txtLoginPassword.getAlpha()<= 1)
                    txtLoginPassword.animate().alpha(0f).setDuration(fadeDuration);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void OnLogin(View v){
        if (edtxtLoginUsername.getText().length()==0 || edtxtLoginPassword.getText().length()==0){
            Toast toast = Toast.makeText (getApplicationContext(), "Wrong name or password", Toast.LENGTH_LONG);
            toast.show();
        }
        else
            startActivity(new Intent(getApplicationContext(), Home.class));
    }

}
