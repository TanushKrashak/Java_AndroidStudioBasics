package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button Calculate;
    EditText Num1,Num2;
    Spinner Options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Setup All Widgets
        Calculate = findViewById(R.id.Calculate);
        Num1 = findViewById(R.id.Num1);
        Num2 = findViewById(R.id.Num2);
        Options = findViewById(R.id.Options);
    }
}