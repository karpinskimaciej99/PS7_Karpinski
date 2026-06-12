import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}