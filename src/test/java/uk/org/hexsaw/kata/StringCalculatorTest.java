package uk.org.hexsaw.kata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private static StringCalculator stringCalculator = StringCalculator.getInstance();

    @Test
    public void canCreateAStringCalculator() {
        assertThat(stringCalculator, notNullValue());
    }

    @Test
    public void whenAddWithEmptyStringThenGetZero() {
        assertThat(stringCalculator.add(""), equalTo(0));
    }

    @Test
    public void whenAddWithSingleNumberThenGetTheNumberSupplied() {
        assertThat(stringCalculator.add("1"), equalTo(1));
    }

    @Test
    public void canPerformAdditionWithTwoNumbersCommaSeperated() {
        assertThat(stringCalculator.add("1,2"), equalTo(3));
    }

    @Test
    public void canPerformAdditionWithLotsOfNumbersCommaSeperated() {
        assertThat(stringCalculator.add("1,2,8,12,6"), equalTo(29));
    }

    @Test
    public void canPerformAdditionWithNumbersInStringWithANewLine() {
        assertThat(stringCalculator.add("1\n2,3"), equalTo(6));
    }

    @Test
    public void canPerformAdditionWithNumbersInStringWithMultipleNewLines() {
        assertThat(stringCalculator.add("9\n2\n3"), equalTo(14));
    }

    @Test
    public void ensureExceptionRaisedWhenDelimiterNewLineAndCommaCombined() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            stringCalculator.add("1\n,3");
        });
    }

    @Test
    public void ensureExceptionRaisedWhenDelimiterCommaAndNewLineCombined() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            stringCalculator.add("1,\n3");
        });
    }

    @Test
    public void canHandleAlternativeDelimiterSpecifiedOnFirstLine() {
        assertThat(stringCalculator.add("//:\n1:2:6"), equalTo(9));
    }

    @Test
    public void canHandleAlternativeDelimiterSpecifiedOnFirstLineWithMultipleLines() {
        assertThat(stringCalculator.add("//:\n1:2:6\n5:2"), equalTo(16));
    }
}
