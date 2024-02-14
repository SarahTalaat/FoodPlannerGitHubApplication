package com.example.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Authentication_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        //show first activity by default

        getSupportFragmentManager().beginTransaction().add(R.id.authentication_activity_frame_layout,new SignUp_Fragment()).commit();



    }
}