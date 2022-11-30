package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class LoopTaskActivity extends AppCompatActivity {

    TextView tvData;
    ArrayList<String> studentNamesArrayList = new ArrayList<>();
    ArrayList<Integer> studentRollNoArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_task);

        tvData = findViewById(R.id.tvData);

        studentNamesArrayList.add("Student A");
        studentNamesArrayList.add("Student B");
        studentNamesArrayList.add("Student C");

        studentRollNoArrayList.add(1);
        studentRollNoArrayList.add(2);
        studentRollNoArrayList.add(3);

        for (int i = 0; i < studentNamesArrayList.size(); i++) {
            String previousData = tvData.getText().toString();
            tvData.setText(previousData + studentRollNoArrayList.get(i) + " " + studentNamesArrayList.get(i) + "\n");
        }
    }
}