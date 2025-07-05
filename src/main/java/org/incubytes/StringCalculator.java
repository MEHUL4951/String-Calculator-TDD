package org.incubytes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


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
        String numberSection = input;
        List<String> delimiters = new ArrayList<>();
        delimiters.add(","); // default comma
        delimiters.add("\n"); // default newline

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            String delimiterPart = input.substring(2, newlineIndex);
            numberSection = input.substring(newlineIndex + 1);

            if (delimiterPart.startsWith("[") && delimiterPart.contains("]")) {
                // Multiple delimiters
                int i = 0;
                while (i < delimiterPart.length()) {
                    int start = delimiterPart.indexOf("[", i);
                    int end = delimiterPart.indexOf("]", start);
                    if (start == -1 || end == -1) break;
                    String delim = delimiterPart.substring(start + 1, end);
                    delimiters.add(delim);
                    i = end + 1;
                }
            } else {
                delimiters.add(delimiterPart); // Single-char delimiter
            }
        }

        // Escape special characters for regex
        for (int i = 0; i < delimiters.size(); i++) {
            delimiters.set(i, Pattern.quote(delimiters.get(i)));
        }

        // Build regex to split with any delimiter
        String delimiterRegex = String.join("|", delimiters);
        return numberSection.split(delimiterRegex);
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
