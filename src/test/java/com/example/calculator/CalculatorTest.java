package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testInitialState() {
        assertEquals(0.0, calculator.getResult(), 0.001);
        assertNotNull(calculator.getOperatingSystem());
    }

    @Test
    void testClear() {
        calculator.add(5);
        calculator.clear();
        assertEquals(0.0, calculator.getResult(), 0.001);
    }

    @Test
    void testSequenceOfOperations() {
        calculator.add(10);
        assertEquals(10.0, calculator.getResult(), 0.001);

        calculator.multiply(2);
        assertEquals(20.0, calculator.getResult(), 0.001);

        calculator.subtract(5);
        assertEquals(15.0, calculator.getResult(), 0.001);

        calculator.divide(3);
        assertEquals(5.0, calculator.getResult(), 0.001);

        calculator.power(2);
        assertEquals(25.0, calculator.getResult(), 0.001);

        calculator.squareRoot();
        assertEquals(5.0, calculator.getResult(), 0.001);
    }

    @Test
    void testCalculateExpression() {
        calculator.calculateExpression("5 + 3");
        assertEquals(8.0, calculator.getResult(), 0.001);

        calculator.clear();
        calculator.calculateExpression("10 - 4");
        assertEquals(6.0, calculator.getResult(), 0.001);
    }

    @Test
    void testCalculateExpressionInvalid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateExpression("5 * 3")
        );

        assertThrows(
                NumberFormatException.class,
                () -> calculator.calculateExpression("abc + def")
        );
    }

    @Test
    void testCrossPlatformInfo() {
        String os = calculator.getOperatingSystem().toLowerCase();

        // Проверяем, что информация об ОС определена
        assertTrue(os.contains("win") || os.contains("linux") ||
                os.contains("mac") || os.contains("nix") ||
                os.contains("nux") || os.contains("aix"));
    }
}