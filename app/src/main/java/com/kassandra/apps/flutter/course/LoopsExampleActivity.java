package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LoopsExampleActivity extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loops_example);

        tvData = findViewById(R.id.tvData);

        String receivedData = getIntent().getExtras().getString("editTextData");
        boolean booleanValue = getIntent().getExtras().getBoolean("valueOfFirstCheckBox");

        tvData.setText(receivedData + "\n" + booleanValue);
    }
}