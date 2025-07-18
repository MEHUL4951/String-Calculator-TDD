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

    @Test
    public void testNumbersGreaterThan1000AreIgnored() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("2,1001");
        assertEquals(2, result);
    }

    @Test
    public void testMultipleLargeNumbersIgnored() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("5,500,1000,1001,12345");
        assertEquals(1505, result);  // only 1000 and below are included
    }

    @Test
    public void testMultiCharDelimiterWithAsterisks() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    public void testMultiCharDelimiterWithLetters() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//[abc]\n5abc1000abc6");
        assertEquals(1011, result);
    }

    @Test
    public void testMultipleSingleCharDelimiters() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    @Test
    public void testMultipleMultiCharDelimiters() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("//[##][!!]\n4##5!!6");
        assertEquals(15, result);
    }




}
