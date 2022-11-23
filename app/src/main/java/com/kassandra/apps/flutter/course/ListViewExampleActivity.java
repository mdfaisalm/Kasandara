package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ListViewExampleActivity extends AppCompatActivity {

    String studentName = "abc";
    String secondStudentName = "xyz";

    String[] studentNamesArray = new String[]{"abc", "xyz", "studentName3", "studentName4"};
    int[] studentRollNosArray = new int[]{1, 2, 3, 4};

    TextView tvStudentNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        tvStudentNames = findViewById(R.id.tvStudentNames);

//        tvStudentNames.setText(studentName + secondStudentName);

        tvStudentNames.setText(studentRollNosArray[0] + " " + studentNamesArray[0] + "\n"
                + studentRollNosArray[1] + " " + studentNamesArray[1] + "\n"
                + studentRollNosArray[2] + " " + studentNamesArray[2] + "\n"
                + studentRollNosArray[3] + " " + studentNamesArray[3]);
    }
}