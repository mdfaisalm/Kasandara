package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    ArrayList<String> studentNamesArrayList = new ArrayList<>();
    ArrayList<String> studentImagesArrayList = new ArrayList<>();
    ArrayList<Integer> studentRollNoArrayList = new ArrayList<>();
    StudentsGridRVAdapter studentsGridRVAdapter;
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);

        rvItems = findViewById(R.id.rvItems);

        studentsGridRVAdapter = new StudentsGridRVAdapter(studentNamesArrayList, studentImagesArrayList,
                studentRollNoArrayList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3
                /*,RecyclerView.HORIZONTAL, false*/);
        rvItems.setAdapter(studentsGridRVAdapter);
        rvItems.setLayoutManager(gridLayoutManager);
    }

    public void addItem(View view) {
        Dialog dialog = new Dialog(this, android.R.style.Theme_Material_NoActionBar_Fullscreen);
        dialog.setContentView(R.layout.dialog_create_student);
        EditText etName = dialog.findViewById(R.id.etName);
        EditText etRollNo = dialog.findViewById(R.id.etRollNo);
        EditText etUrl = dialog.findViewById(R.id.etUrl);
        Button btnAddStudent = dialog.findViewById(R.id.btnAddStudent);

        btnAddStudent.setOnClickListener(v -> {
            String name = etName.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
                return;
            }
            String rollNo = etRollNo.getText().toString();
            if (rollNo.isEmpty()) {
                Toast.makeText(this, "Please enter roll no", Toast.LENGTH_SHORT).show();
                return;
            }
            String url = etUrl.getText().toString();
            if (url.isEmpty()) {
                Toast.makeText(this, "Please enter url", Toast.LENGTH_SHORT).show();
                return;
            }
            studentNamesArrayList.add(name);
            studentRollNoArrayList.add(Integer.parseInt(rollNo));
            studentImagesArrayList.add(url);
            studentsGridRVAdapter.notifyDataSetChanged();
            dialog.dismiss();
        });
        dialog.show();
    }
}