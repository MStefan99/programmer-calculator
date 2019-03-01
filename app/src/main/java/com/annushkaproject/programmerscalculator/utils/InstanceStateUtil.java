package com.annushkaproject.programmerscalculator.utils;

import android.os.Bundle;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Operator;
import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.WordLength;

public class InstanceStateUtil {

    public static CalculationModel restoreSavedInstance(Bundle savedInstanceState) {
        CalculationModel calcModel = new CalculationModel();
            if (savedInstanceState.getBoolean("FIRST_VALUE_SAVED")) {
                calcModel.setFirstValue(savedInstanceState.getDouble("FIRST_VALUE"));
            }
            if (savedInstanceState.getBoolean("OPERATOR_SAVED")) {
                calcModel.setOperator(Operator.getOperatorByNumber(savedInstanceState.getInt("OPERATOR")));
            }
            if (savedInstanceState.getBoolean("SECOND_VALUE_SAVED")) {
                calcModel.setSecondValue(savedInstanceState.getDouble("SECOND_VALUE"));
            }
        return calcModel;
    }

    public static ProgrammerCalcModel restoreProgrammerSavedInstance(Bundle savedInstanceState) {
        ProgrammerCalcModel calcModel = new ProgrammerCalcModel();
        if (savedInstanceState.getBoolean("FIRST_VALUE_SAVED")) {
            calcModel.setFirstValue(savedInstanceState.getDouble("FIRST_VALUE"));
        }
        if (savedInstanceState.getBoolean("OPERATOR_SAVED")) {
            calcModel.setOperator(Operator.getOperatorByNumber(savedInstanceState.getInt("OPERATOR")));
        }
        if (savedInstanceState.getBoolean("SECOND_VALUE_SAVED")) {
            calcModel.setSecondValue(savedInstanceState.getDouble("SECOND_VALUE"));
        }
        calcModel.setSecondValue(savedInstanceState.getDouble("WORD_LENGTH"));
        return calcModel;
    }

    public static void saveInstanceState(Bundle outState, CalculationModel calcModel, String packageName) {
        outState.putString("PACKAGE_NAME", packageName);
        boolean firstValuePresent = calcModel.getFirstValue() != null;
        boolean operatorPresent = calcModel.getOperator() != null;
        boolean secondValuePresent = calcModel.getSecondValue() != null;
        if (firstValuePresent) {
            outState.putDouble("FIRST_VALUE", calcModel.getFirstValue().doubleValue());
        }
        if (operatorPresent) {
            outState.putInt("OPERATOR", Operator.getNumberByOperator(calcModel.getOperator()));
        }
        if (secondValuePresent) {
            outState.putDouble("SECOND_VALUE", calcModel.getSecondValue().doubleValue());
        }
        outState.putBoolean("FIRST_VALUE_SAVED", firstValuePresent);
        outState.putBoolean("OPERATOR_SAVED", operatorPresent);
        outState.putBoolean("SECOND_VALUE_SAVED", secondValuePresent);
    }

    public static void saveInstanceState(Bundle outState, ProgrammerCalcModel calcModel, String packageName) {
        outState.putString("PACKAGE_NAME", packageName);
        boolean firstValuePresent = calcModel.getFirstValue() != null;
        boolean operatorPresent = calcModel.getOperator() != null;
        boolean secondValuePresent = calcModel.getSecondValue() != null;
        if (firstValuePresent) {
            outState.putDouble("FIRST_VALUE", calcModel.getFirstValue().doubleValue());
        }
        if (operatorPresent) {
            outState.putInt("OPERATOR", Operator.getNumberByOperator(calcModel.getOperator()));
        }
        if (secondValuePresent) {
            outState.putDouble("SECOND_VALUE", calcModel.getSecondValue().doubleValue());
        }
        outState.putInt("WORD_LENGTH", calcModel.getWordLength().wordToInt());
        outState.putBoolean("FIRST_VALUE_SAVED", firstValuePresent);
        outState.putBoolean("OPERATOR_SAVED", operatorPresent);
        outState.putBoolean("SECOND_VALUE_SAVED", secondValuePresent);
    }
}