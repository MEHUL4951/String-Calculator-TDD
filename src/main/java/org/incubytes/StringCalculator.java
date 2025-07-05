package org.incubytes;
import java.util.ArrayList;
import java.util.List;


public class StringCalculator
{

    private int addCallCount = 0;
    private static  final int MAX_ALLOWED = 1000;

    public int Add(String numbers) {
        addCallCount++;
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] parts = normalizeDelimiters(numbers);
        return sum(parts);
    }

    public int GetCalledCount() {
        return addCallCount;
    }


    private String[] normalizeDelimiters(String input) {
        String delimiter = ",";
        String numberSection = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            String delimiterPart = input.substring(2, newlineIndex);

            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                delimiter = delimiterPart.substring(1, delimiterPart.length() - 1); // multi-char
            } else {
                delimiter = delimiterPart; // single-char
            }

            numberSection = input.substring(newlineIndex + 1);
        }

        // Normalize all delimiters to comma
        numberSection = numberSection.replace("\n", ",").replace(delimiter, ",");
        return numberSection.split(",");
    }
    private int sum(String[] parts) {
        int total = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (part.isEmpty()) continue;
            int number = Integer.parseInt(part.trim());
            if (number < 0) {
                negatives.add(number);
            } else if(number<=MAX_ALLOWED){
                total += number;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(generateNegativeMessage(negatives));
        }
        return total;
    }

    private String generateNegativeMessage(List<Integer> negatives) {
        return "Negatives not allowed: " + String.join(", ",
                negatives.stream().map(String::valueOf).toArray(String[]::new));
    }
}
