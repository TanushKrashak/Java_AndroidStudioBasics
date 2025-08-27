package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView Res;
    EditText Input;
    Button Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Res = findViewById(R.id.Answer);
        String name = getIntent().getStringExtra("Name");
        Res.setText(name.toString());

        Input = findViewById(R.id.Num2);
        Send = findViewById(R.id.Send);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Name2", Input.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}