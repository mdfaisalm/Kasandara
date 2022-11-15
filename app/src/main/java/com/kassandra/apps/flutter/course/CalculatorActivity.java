package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    EditText etInput;
    TextView tvResult;
    String operation = "";
    int firstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etInput = findViewById(R.id.etInput);
        tvResult = findViewById(R.id.tvResult);

    }

    public void prepareFirstNumber() {
        String firstNumberStr = etInput.getText().toString();
        if (firstNumberStr.isEmpty()) {
            Toast.makeText(CalculatorActivity.this, "Please enter first number",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        firstNumber = Integer.parseInt(firstNumberStr);
        etInput.setText("");
    }

    public void addition(View view) {
        prepareFirstNumber();
        operation = "add";
    }

    public void subtraction(View view) {
        prepareFirstNumber();
        operation = "sub";
    }

    public void multiply(View view) {
        prepareFirstNumber();
        operation = "mul";
    }

    public void division(View view) {
        prepareFirstNumber();
        operation = "div";
    }

    public void getResult(View view) {
        String secondNumberStr = etInput.getText().toString();
        if (firstNumber == 0) {
            Toast.makeText(CalculatorActivity.this, "Please enter first number",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (secondNumberStr.isEmpty()) {
            Toast.makeText(CalculatorActivity.this, "Please enter second number",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        int secondNumber = Integer.parseInt(secondNumberStr);
        int result = 0;
        CalculatorHelper calculatorHelper = new CalculatorHelper();
        switch (operation) {
            case "add":
                result = calculatorHelper.calculateAddition(firstNumber, secondNumber);
                break;
            case "sub":
                result = calculatorHelper.calculateSubtraction(firstNumber, secondNumber);
                break;
            case "mul":
                result = calculatorHelper.calculateMultiplication(firstNumber, secondNumber);
                break;
            case "div":
                result = calculatorHelper.calculateDivision(firstNumber, secondNumber);
                break;
        }
        tvResult.setText(String.valueOf(result));
    }

    public void clearInput(View view) {
        etInput.setText("");
    }
}