package com.kassandra.apps.flutter.course;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button btnGetResult, btnMoveToSecondActivity;
    TextView tvResult;
    EditText etUserName, etTableNumber;
    CheckBox cbFirstCourse;
    ImageView ivOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivOnline = findViewById(R.id.ivOnline);
        btnGetResult = findViewById(R.id.btnGetResult);
        tvResult = findViewById(R.id.tvResult);
        etUserName = findViewById(R.id.etUserName);
        btnMoveToSecondActivity = findViewById(R.id.btnMoveToSecondActivity);
        etTableNumber = findViewById(R.id.etTableNumber);
        cbFirstCourse = findViewById(R.id.cbFirstCourse);

        Glide.with(this).load("https://media.geeksforgeeks.org/wp-content/cdn-uploads/Access-Modifiers-in-Java.png").into(ivOnline);


        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "My Dummy Message", Toast.LENGTH_SHORT).show();
                String userNameStr = etUserName.getText().toString();
                tvResult.setText(userNameStr);
            }
        });

        btnMoveToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movingTOOtherActivityIntent = new Intent(MainActivity.this, LoopsExampleActivity.class);
                movingTOOtherActivityIntent.putExtra("editTextData", etUserName.getText().toString());
                String tableNoStr = etTableNumber.getText().toString();
                int tableNo = Integer.parseInt(tableNoStr);
                movingTOOtherActivityIntent.putExtra("tableNo", tableNo);
                movingTOOtherActivityIntent.putExtra("valueOfFirstCheckBox", cbFirstCourse.isChecked());
                startActivity(movingTOOtherActivityIntent);
            }
        });
    }

    public void moveToConditionActivity(View view) {
        Intent movingTOOtherActivityIntent = new Intent(MainActivity.this, ConditionsExampleActivity.class);
        startActivity(movingTOOtherActivityIntent);
    }

    public void moveToCalculatorActivity(View view) {
        Intent movingTOOtherActivityIntent = new Intent(MainActivity.this, CalculatorActivity.class);
        startActivity(movingTOOtherActivityIntent);
    }
}