package org.incubytes;
import java.util.ArrayList;
import java.util.List;


public class StringCalculator
{

    public int Add(String numbers) {
          if(numbers.isEmpty()){
               return 0;
          }
          String delimiter = ",";
          String numberSection = numbers;
          if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEndIndex);
            numberSection = numbers.substring(delimiterEndIndex + 1);
         }
        String sanitized = numberSection.replace("\n", delimiter.equals("\n") ? "," : ",")
                .replace(delimiter, ",");
          String[] digits = sanitized.split(",");
          int totalsum = sum(digits);
          return totalsum;
    }

    private int sum(String[] parts) {
        int total = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (part.isEmpty()) continue;
            int number = Integer.parseInt(part.trim());
            if (number < 0) {
                negatives.add(number);
            } else {
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
