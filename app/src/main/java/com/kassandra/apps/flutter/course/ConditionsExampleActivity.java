package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConditionsExampleActivity extends AppCompatActivity {

    EditText etAge, etCharacter;
    TextView tvResult, tvCharacterResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions_example);

        etAge = findViewById(R.id.etAge);
        tvResult = findViewById(R.id.tvResult);
        etCharacter = findViewById(R.id.etCharacter);
        tvCharacterResult = findViewById(R.id.tvCharacterResult);
    }

    //0-3 baby
    //4-13 child
    //14-more adult
    public void getAgeGroup(View view) {
        String ageStr = etAge.getText().toString();
        int age = Integer.parseInt(ageStr);
        if (age < 4) {
            tvResult.setText("User is a kid");
        } else if (age > 4 && age < 14) {
            tvResult.setText("User is a child");
        } else if (age > 13) {
            tvResult.setText("User is an adult");
        }
    }

    public void getCharacterResult(View view) {
        String character = etCharacter.getText().toString();
        if (character.equalsIgnoreCase("g")) {
            tvCharacterResult.setText("Girl");
        } else if (character.equalsIgnoreCase("b")) {
            tvCharacterResult.setText("Boy");
        } else if (character.equalsIgnoreCase("k")) {
            tvCharacterResult.setText("Kid");
        } else if (character.equalsIgnoreCase("a")) {
            tvCharacterResult.setText("Adult");
        } else {
            tvCharacterResult.setText("Wrong Character");
        }
/*
        switch (character) {
            case "g":
                tvCharacterResult.setText("Girl");
                break;
            case "b":
                tvCharacterResult.setText("Baby");
                break;
            case "k":
                tvCharacterResult.setText("Kid");
                break;
            case "a":
                tvCharacterResult.setText("Adult");
                break;
            default:
                tvCharacterResult.setText("Wrong Character");
        }
*/
    }
}