package com.kassandra.apps.flutter.course;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button btnGetResult, btnMoveToSecondActivity;
    TextView tvResult, tvEmail;
    EditText etUserName, etTableNumber;
    CheckBox cbFirstCourse;
    ImageView ivOnline;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivOnline = findViewById(R.id.ivOnline);
        btnGetResult = findViewById(R.id.btnGetResult);
        tvResult = findViewById(R.id.tvResult);
        etUserName = findViewById(R.id.etUserName);
        tvEmail = findViewById(R.id.tvEmail);
        btnMoveToSecondActivity = findViewById(R.id.btnMoveToSecondActivity);
        etTableNumber = findViewById(R.id.etTableNumber);
        cbFirstCourse = findViewById(R.id.cbFirstCourse);

        Glide.with(this).load(R.drawable.download).into(ivOnline);

        sharedPreferences = getSharedPreferences("loginSP", MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", "Email not found");

        tvEmail.setText("Welcome " + userEmail);

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

    public void logout(View view) {
        Toast.makeText(this, "Logout successful!", Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isUserLogin", false);
        editor.commit();
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    public void moveToListViewExampleActivity(View view) {
        Intent movingTOOtherActivityIntent = new Intent(MainActivity.this, ListViewExampleActivity.class);
        startActivity(movingTOOtherActivityIntent);
    }
}