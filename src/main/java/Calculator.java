public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numberPart = numbers;

        if (numbers.startsWith("//")) {
            int newLineIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, newLineIndex);
            numberPart = numbers.substring(newLineIndex + 1);
        }

        String[] parts = numberPart.split(delimiter);
        int sum = 0;

        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        return sum;
    }
}