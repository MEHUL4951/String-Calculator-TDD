package org.incubytes;
import java.util.ArrayList;
import java.util.List;


public class StringCalculator
{

    public int Add(String numbers) {
          if(numbers.isEmpty()){
               return 0;
          }
          String[] digits = normalizeDelimiters(numbers);
          int totalsum = sum(digits);
          return totalsum;
    }
    private String[] normalizeDelimiters(String input) {
        return input.replace("\n", ",").split(",");
    }
    private int sum(String[] parts) {
        int total = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String part : parts) {
            int number = Integer.parseInt(part.trim());
            if (number < 0) {
                negatives.add(number);
            } else {
                total += number;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString().replace("[", "").replace("]", ""));
        }

        return total;
    }
}
