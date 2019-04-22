package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void onClick(View view) {
         Intent intent = new Intent(this, surveyView.class);
         startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, recordView.class);
        startActivity(intent);
    }
}
