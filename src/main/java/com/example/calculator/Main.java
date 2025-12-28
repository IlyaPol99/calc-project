package com.example.calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cross-Platform Calculator ===");
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("Architecture: " + System.getProperty("os.arch"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println();

        // Демонстрация работы калькулятора
        Calculator calc = new Calculator();

        System.out.println("Basic operations:");
        calc.add(10);
        System.out.println("10 = " + calc.getResult());

        calc.multiply(3);
        System.out.println("× 3 = " + calc.getResult());

        calc.subtract(5);
        System.out.println("- 5 = " + calc.getResult());

        calc.divide(2);
        System.out.println("÷ 2 = " + calc.getResult());

        System.out.println("\nMath functions:");
        System.out.println("Factorial of 5: " + MathOperations.factorial(5));
        System.out.println("Is 17 prime? " + MathOperations.isPrime(17));
        System.out.println("Is 8 even? " + MathOperations.isEven(8));
        System.out.println("Square root of 16: " + MathOperations.squareRoot(16));

        System.out.println("\n=== Program completed successfully ===");
    }
}