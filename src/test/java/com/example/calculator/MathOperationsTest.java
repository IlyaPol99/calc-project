package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MathOperationsTest {

    @Test
    void testAdd() {
        assertEquals(5.0, MathOperations.add(2.0, 3.0), 0.001);
        assertEquals(0.0, MathOperations.add(-2.0, 2.0), 0.001);
        assertEquals(-5.0, MathOperations.add(-2.0, -3.0), 0.001);
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, MathOperations.subtract(3.0, 2.0), 0.001);
        assertEquals(-1.0, MathOperations.subtract(2.0, 3.0), 0.001);
        assertEquals(0.0, MathOperations.subtract(2.0, 2.0), 0.001);
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, MathOperations.multiply(2.0, 3.0), 0.001);
        assertEquals(-6.0, MathOperations.multiply(2.0, -3.0), 0.001);
        assertEquals(0.0, MathOperations.multiply(0.0, 5.0), 0.001);
    }

    @Test
    void testDivide() {
        assertEquals(2.0, MathOperations.divide(6.0, 3.0), 0.001);
        assertEquals(-2.0, MathOperations.divide(6.0, -3.0), 0.001);
        assertEquals(0.5, MathOperations.divide(1.0, 2.0), 0.001);
    }

    @Test
    void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MathOperations.divide(5.0, 0.0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testPower() {
        assertEquals(8.0, MathOperations.power(2.0, 3.0), 0.001);
        assertEquals(1.0, MathOperations.power(5.0, 0.0), 0.001);
        assertEquals(0.25, MathOperations.power(2.0, -2.0), 0.001);
    }

    @Test
    void testSquareRoot() {
        assertEquals(4.0, MathOperations.squareRoot(16.0), 0.001);
        assertEquals(0.0, MathOperations.squareRoot(0.0), 0.001);
        assertEquals(1.414, MathOperations.squareRoot(2.0), 0.001);
    }

    @Test
    void testSquareRootOfNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MathOperations.squareRoot(-1.0)
        );
        assertEquals("Cannot calculate square root of negative number", exception.getMessage());
    }

    @Test
    void testFactorial() {
        assertEquals(1, MathOperations.factorial(0));
        assertEquals(1, MathOperations.factorial(1));
        assertEquals(120, MathOperations.factorial(5));
        assertEquals(3628800, MathOperations.factorial(10));
    }

    @Test
    void testFactorialNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MathOperations.factorial(-5)
        );
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 0, -2, -4})
    void testIsEven(int number) {
        boolean expected = number % 2 == 0;
        assertEquals(expected, MathOperations.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({
            "2, true",
            "3, true",
            "4, false",
            "17, true",
            "18, false",
            "1, false",
            "0, false",
            "-5, false"
    })
    void testIsPrime(int number, boolean expected) {
        assertEquals(expected, MathOperations.isPrime(number));
    }
}