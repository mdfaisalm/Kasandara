package com.kassandra.apps.flutter.newDummy;

import com.kassandra.apps.flutter.newDummy.ParentCalculatorHelper;

public class CalculatorHelper extends ParentCalculatorHelper {

    @Override
    public int calculateAddition(int firstNumber, int secondNumber) {
        return super.calculateAddition(firstNumber, secondNumber);
    }

    public int calculateMultiplication(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        calculateAddition(2, 2);
        return result;
    }

    public int calculateDivision(int firstNumber, int secondNumber) {
        int result = firstNumber / secondNumber;
        return result;
    }
}
