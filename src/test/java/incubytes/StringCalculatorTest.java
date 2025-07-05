package incubytes;

import org.incubytes.Main;
import org.incubytes.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    void testEmptyStringReturnsZero(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(0,calculator.Add(""));
    }

    @Test
    void stestSingleNumberReturnsItself(){
          StringCalculator calculator = new StringCalculator();
          assertEquals(3,calculator.Add("3"));
    }

    @Test
    void testTwoNumbersReturnTheirSum(){
          StringCalculator calculator = new StringCalculator();
          assertEquals(11,calculator.Add("5,6"));
    }
    @Test
    void estMultipleNumbersReturnTheirSum(){
         StringCalculator calculator = new StringCalculator();
         assertEquals(50,calculator.Add("5,10,15,20"));
    }
    @Test
    public void testUnknownAmountOfNumbersReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("10,20,30,40,50,60,70,80,90,100");
        assertEquals(550, result);
    }

    @Test
    public void testNegativeNumbersThrowException() {
        StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.Add("1,-2,3,-4");
        });
        assertEquals("Negatives not allowed: -2, -4", exception.getMessage());
    }
    @Test
    public void testCustomDelimiterSemicolon() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void testCustomDelimiterPipe() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//|\n4|5|6");
        assertEquals(15, result);
    }

    @Test
    public void testMultipleNegativesShowAllInExceptionMessage() {
        StringCalculator calculator = new StringCalculator();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.Add("2,-4,3,-9");
        });
        assertEquals("Negatives not allowed: -4, -9", exception.getMessage());
    }

    @Test
    public void testGetCalledCountReturnsCorrectInvocationCount() {
        StringCalculator calculator = new StringCalculator();

        calculator.Add("1,2");
        calculator.Add("3,4");
        calculator.Add("5");

        assertEquals(3, calculator.GetCalledCount());
    }

}
