package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    ListView List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        List = findViewById(R.id.List);
        ArrayList<String> DataList = new ArrayList<>();
        DataList.add("Name: ABC");
        DataList.add("Contact Numebr: 192i3921i31");
        DataList.add("Email: ABC@gmail.com");
        DataList.add("College: NMIMS");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DataList);
        List.setAdapter(adapter);

    }
}