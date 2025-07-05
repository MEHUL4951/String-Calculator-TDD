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



}
