package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button Calculate;
    EditText Num1,Num2;
    Spinner Options;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Setup All Widgets
        Calculate = findViewById(R.id.Calculate);
        Num1 = findViewById(R.id.Num1);
        Num2 = findViewById(R.id.Num2);
        Options = findViewById(R.id.Options);
        Result = findViewById(R.id.Answer);

        ArrayList<String> Option = new ArrayList<>();
        Option.add("+");
        Option.add("-");
        Option.add("*");
        Option.add("/");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.spinner_list, R.id.value ,Option);
        Options.setAdapter(adapter);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = Num1.getText().toString();
                if (temp.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter Num 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                double num1 = Double.parseDouble(temp);
                temp = Num2.getText().toString();
                if (temp.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter Num 2", Toast.LENGTH_SHORT).show();
                    return;
                }
                double num2 = Double.parseDouble(temp.toString());
                String operator = Options.getSelectedItem().toString();
                Double result = 0.;
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            Toast.makeText(MainActivity.this, "ENTER NON 0", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        result = num1 / num2;
                        break;
                }
                String out = "Result: " + result.toString();
                Result.setText(out);
            }
        });
    }
}