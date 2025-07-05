package org.incubytes;

public class StringCalculator
{

    public int add(String numbers) {
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
    private int sum(String[] digits) {
        int total = 0;
        for (String digit : digits) {
            total += Integer.parseInt(digit.trim());
        }
        return total;
    }
}
