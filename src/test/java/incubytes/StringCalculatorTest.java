package incubytes;

import org.incubytes.Main;
import org.incubytes.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    void testEmptyStringReturnsZero(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(0,calculator.add(""));
    }

    @Test
    void stestSingleNumberReturnsItself(){
          StringCalculator calculator = new StringCalculator();
          assertEquals(3,calculator.add("3"));
    }

    @Test
    void testTwoNumbersReturnTheirSum(){
          StringCalculator calculator = new StringCalculator();
          assertEquals(11,calculator.add("5,6"));
    }
    @Test
    void estMultipleNumbersReturnTheirSum(){
         StringCalculator calculator = new StringCalculator();
         assertEquals(50,calculator.add("5,10,15,20"));
    }
    @Test
    public void testUnknownAmountOfNumbersReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("10,20,30,40,50,60,70,80,90,100");
        assertEquals(550, result);
    }




}
