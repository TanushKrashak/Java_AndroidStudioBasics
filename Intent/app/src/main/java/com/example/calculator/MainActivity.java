package com.example.calculator;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Calculate;
    EditText Num1;
    TextView Result;

    ActivityResultLauncher<Intent> Launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Setup All Widgets
        Calculate = findViewById(R.id.Send);
        Num1 = findViewById(R.id.Num1);
        Result = findViewById(R.id.Answer);

        Launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        Result.setText(data.toString());
                    }
                });

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = Num1.getText().toString();
                if (temp.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter Value", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("Name", temp);
                Launcher.launch(intent);
            }
        });
    }
}