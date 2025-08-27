package com.example.calculator;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Send;
    EditText Num1;
    TextView Result;

    ActivityResultLauncher<Intent> Launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Setup All Widgets
        Send = findViewById(R.id.Google);

        Launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                    }
                });

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("geo:0,0?q=Mukesh Patel School of Technology Management");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                intent.setPackage("com.google.android.apps.maps");
                Launcher.launch(intent);
            }
        });
    }
}