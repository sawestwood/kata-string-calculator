package uk.org.hexsaw.kata;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;

public class CalculatorInputDigesterTest {

    private CalculatorInputDigester calculatorInputDigester;

    @Test
    public void canCreateCalculatorInputDigester() {
        calculatorInputDigester = new CalculatorInputDigester("1,2,3");
        assertThat(calculatorInputDigester, notNullValue());
    }

    @Test
    public void thatDigesterCanDigestASimpleInputStringWithCommaDelimitedNumbers() {
        calculatorInputDigester = new CalculatorInputDigester("1,2,3");
        assertThat(calculatorInputDigester.getInputNumbers(), hasItems(1, 2, 3));
    }

    @Test
    public void allowsForNewlineAsDelimiterAsWellAsComma() {
        calculatorInputDigester = new CalculatorInputDigester("1,2,3");
        assertThat(calculatorInputDigester.getDelimiterAsRegex(), equalTo(",|\n"));
    }

    @Test
    public void allowsForAlternativeDelimiterToComma() {
        calculatorInputDigester = new CalculatorInputDigester("//:\n1:2:3");
        assertThat(calculatorInputDigester.getDelimiterAsRegex(), equalTo(":|\n"));
    }

    @Test
    public void allowsForAlternativeDelimiterToCommaWithMultipleLines() {
        calculatorInputDigester = new CalculatorInputDigester("//:\n1:2:3\n8:9");
        assertThat(calculatorInputDigester.getDelimiterAsRegex(), equalTo(":|\n"));
        assertThat(calculatorInputDigester.getInputNumbers(), hasItems(1, 2, 3, 8, 9));
    }
}
