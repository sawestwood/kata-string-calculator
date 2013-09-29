package uk.org.hexsaw.kata;

import java.util.ArrayList;
import java.util.List;

public class CalculatorInputDigester {
    
    private String input = null;
    private boolean delimiterLine = false;
    private static final String REGEX_OR = "|";
    private static final String NEWLINE_DELIMITED = "\n";   
    private static final String COMMA_DELIMITED = ",";
    private String delimiterAsRegex = COMMA_DELIMITED + REGEX_OR + NEWLINE_DELIMITED;
    
    private List<Integer> inputNumbers = new ArrayList<>();

    public CalculatorInputDigester(String input) {
        this.input = input;
        if(input != null && !input.isEmpty()) {
            
            if (input.startsWith("//")) {
                this.delimiterLine = true;
                this.delimiterAsRegex = input.substring(2, input.indexOf("\n")) + REGEX_OR + NEWLINE_DELIMITED;
                input = input.substring(input.indexOf("\n") + 1);
            }          
            String[] numbers = input.split(this.delimiterAsRegex);
            for (int i = 0; i < (numbers.length); ++i) {
                inputNumbers.add(Integer.parseInt(numbers[i]));
            }
        }
    }

    public List<Integer> getInputNumbers() {
        return this.inputNumbers;
    }

    public String getDelimiterAsRegex() {
        return this.delimiterAsRegex;
    }
    
    public boolean hasDelimiterLine() {
        return delimiterLine;
    }

}
