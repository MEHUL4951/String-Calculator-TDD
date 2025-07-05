package org.incubytes;

public class StringCalculator
{

    public int add(String numbers) {
          if(numbers.isEmpty()){
               return 0;
          }
          String[] digits = numbers.split(",");
          int totalSum = 0;
          for (String part : digits) {
              totalSum += Integer.parseInt(part);
          }
          return totalSum;
    }
}
