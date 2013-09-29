package uk.org.hexsaw.kata;

public class StringCalculatorOld {

    private static final String COMMA_DELIMITER = ",";
    
    private static StringCalculatorOld instance = null;

    private StringCalculatorOld() {
    }

    public static StringCalculatorOld getInstance() {
        if (instance == null) {
            instance = new StringCalculatorOld();
        }
        return instance;
    }

    public int add(String input) {
        String delimiter = COMMA_DELIMITER;
        if (input == null || input.isEmpty()) {
            return 0;
        } else {
            boolean hasDelimiterLine = this.hasDelimiterLine(input);
            if (hasDelimiterLine) {
                delimiter = this.extractDelimiter(input);   
                input = input.substring(input.indexOf("\n") + 1);
            }
            String[] numbers = input.split(delimiter + "|\n");
            int total = 0;
            for (int i = 0; i < (numbers.length); ++i) {
                total += Integer.parseInt(numbers[i]);
            }
            return total;
        }
    }
    
    private String extractDelimiter(String input) {
        if(input != null && !input.isEmpty() && input.startsWith("//")) {
            return input.substring(2, input.indexOf("\n"));
        } else {
            return COMMA_DELIMITER;
        }
    }
    
    private boolean hasDelimiterLine(String input) {
        return (input != null && !input.isEmpty() && input.startsWith("//"));
    }
}
