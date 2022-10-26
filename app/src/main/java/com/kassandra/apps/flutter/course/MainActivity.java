package com.kassandra.apps.flutter.course;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnGetResult;
    TextView tvResult;
    EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetResult = findViewById(R.id.btnGetResult);
        tvResult = findViewById(R.id.tvResult);
        etUserName = findViewById(R.id.etUserName);

        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "My Dummy Message", Toast.LENGTH_SHORT).show();
                String userNameStr = etUserName.getText().toString();
                tvResult.setText(userNameStr);
            }
        });

    }
}