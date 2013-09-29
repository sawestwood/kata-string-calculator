package uk.org.hexsaw.kata;

import java.util.List;

public class StringCalculator {
    
    private static StringCalculator instance = null;

    private StringCalculator() {
    }

    public static StringCalculator getInstance() {
        if (instance == null) {
            instance = new StringCalculator();
        }
        return instance;
    }

    public int add(String input) {
        CalculatorInputDigester inputDigester = new CalculatorInputDigester(input);
        int total = 0;
        List<Integer> inputNumbers = inputDigester.getInputNumbers();
        for (Integer inputNumber : inputNumbers) {
            total += inputNumber;
        }
        return total;

    }
    
}
