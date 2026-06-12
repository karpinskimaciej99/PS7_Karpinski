import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void shouldReturnZeroForEmptyString() {
        Calculator calculator = new Calculator();

        int result = calculator.add("");

        assertThat(result).isEqualTo(0);
    }
}