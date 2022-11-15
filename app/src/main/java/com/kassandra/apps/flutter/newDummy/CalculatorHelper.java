package com.kassandra.apps.flutter.newDummy;

import com.kassandra.apps.flutter.newDummy.ParentCalculatorHelper;

public class CalculatorHelper extends ParentCalculatorHelper {

    public int calculateMultiplication(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        calculateAddition(2,2);
        return result;
    }

    public int calculateDivision(int firstNumber, int secondNumber) {
        int result = firstNumber / secondNumber;
        return result;
    }
}
