package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class RecyclerViewExampleActivity extends AppCompatActivity {

    ArrayList<String> studentNamesArrayList = new ArrayList<>();
    ArrayList<Integer> studentImagesArrayList = new ArrayList<>();
    ItemsRVAdapter itemsRVAdapter;
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);

        rvItems = findViewById(R.id.rvItems);

        itemsRVAdapter = new ItemsRVAdapter(studentNamesArrayList, studentImagesArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                true);
        rvItems.setLayoutManager(linearLayoutManager);
        rvItems.setAdapter(itemsRVAdapter);
    }

    public void addItem(View view) {
        int size = studentNamesArrayList.size() + 1;
        studentNamesArrayList.add("new Item " + size);
        studentImagesArrayList.add(R.mipmap.ic_launcher);
        itemsRVAdapter.notifyDataSetChanged();
    }

}