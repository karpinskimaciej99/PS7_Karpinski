import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numberPart = numbers;

        if (numbers.startsWith("//")) {
            int newLineIndex = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, newLineIndex);
            numberPart = numbers.substring(newLineIndex + 1);

            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                delimiter = Pattern.quote(delimiterPart.substring(1, delimiterPart.length() - 1));
            } else {
                delimiter = Pattern.quote(delimiterPart);
            }
        }

        String[] parts = numberPart.split(delimiter);
        int sum = 0;
        List<String> negatives = new ArrayList<>();

        for (String part : parts) {
            int number = Integer.parseInt(part);

            if (number < 0) {
                negatives.add(part);
            }

            if (number <= 1000) {
                sum += number;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + String.join(", ", negatives));
        }

        return sum;
    }
}