package com.app.purna;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @Test
    public  void  testMultiply() {
        calculator = new Calculator();
        Assertions.assertEquals(20, calculator.multiply(5, 4));
       // Assertions.assertEquals(25, calculator.multiply(5, 5));
    }

    @Test
    public void testDivide()
    {
        calculator = new Calculator();
        Assertions.assertEquals( 4, calculator.divide(20,5));
    }
}
