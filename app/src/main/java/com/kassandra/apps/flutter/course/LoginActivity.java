package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_login_screen_with_linearlayout);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
    }

    public void login(View view) {
        String emailStr = etEmail.getText().toString();
        if (emailStr.isEmpty()) {
            Toast.makeText(this, "Please enter email!", Toast.LENGTH_SHORT).show();
            return;
        }
        String passStr = etPass.getText().toString();
        if (passStr.isEmpty()) {
            Toast.makeText(this, "Please enter password!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (emailStr.equals("abc@gmail.com") && passStr.equals("1234")) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("loginSP", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isUserLogin", true);
            editor.putString("userEmail", emailStr);
            editor.commit();
            finish();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        } else {
            Toast.makeText(this, "Wrong login detail!", Toast.LENGTH_SHORT).show();
        }
    }
}