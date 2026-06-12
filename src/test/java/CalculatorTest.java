import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void shouldReturnZeroForEmptyString() {
        Calculator calculator = new Calculator();

        int result = calculator.add("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldReturnNumberWhenSingleNumberGiven() {
        Calculator calculator = new Calculator();

        int result = calculator.add("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldReturnSumWhenTwoNumbersGiven() {
        Calculator calculator = new Calculator();

        int result = calculator.add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldReturnSumWhenUnknownAmountOfNumbersGiven() {
        Calculator calculator = new Calculator();

        int result = calculator.add("1,2,3,4");

        assertThat(result).isEqualTo(10);
    }

    @Test
    void shouldReturnSumWhenNewLineBetweenNumbersGiven() {
        Calculator calculator = new Calculator();

        int result = calculator.add("1\n2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldReturnSumWhenCustomDelimiterGiven() {
        Calculator calculator = new Calculator();

        int result = calculator.add("//;\n1;2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumberGiven() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.add("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("negatives not allowed: -2");
    }

    @Test
    void shouldThrowExceptionWithAllNegativeNumbers() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.add("1,-2,-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("negatives not allowed: -2, -3");
    }
}