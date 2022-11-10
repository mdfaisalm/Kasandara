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
        int tableNumber = getIntent().getExtras().getInt("tableNo");

        //3x1=3
        //3x2=6
        //3x3=9
/*
        tvData.setText(tableNumber + "x1=" + tableNumber * 1 + "\n" +
                tableNumber + "x2=" + tableNumber * 2 + "\n" +
                tableNumber + "x3=" + tableNumber * 3 + "\n" +
                tableNumber + "x4=" + tableNumber * 4 + "\n" +
                tableNumber + "x5=" + tableNumber * 5 + "\n" +
                tableNumber + "x6=" + tableNumber * 6 + "\n" +
                tableNumber + "x7=" + tableNumber * 7 + "\n" +
                tableNumber + "x8=" + tableNumber * 8 + "\n" +
                tableNumber + "x9=" + tableNumber * 9 + "\n" +
                tableNumber + "x10=" + tableNumber * 10);
*/

/*
        for (int i = 1; i < 10; i++) {
            String previousData = tvData.getText().toString();
            tvData.setText(previousData + tableNumber + "x" + i + "=" + tableNumber * i + "\n");
        }
*/

        int i = 10;
        while (i > 0) {
            String previousData = tvData.getText().toString();
            tvData.setText(previousData + tableNumber + "x" + i + "=" + tableNumber * i + "\n");
            i--;
        }

    }
}