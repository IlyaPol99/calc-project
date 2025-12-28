package com.example.calculator;

public class Calculator {
    private double result;
    private final String osName;

    public Calculator() {
        this.result = 0;
        this.osName = System.getProperty("os.name");
    }

    public void clear() {
        this.result = 0;
    }

    public double getResult() {
        return this.result;
    }

    public String getOperatingSystem() {
        return this.osName;
    }

    public void add(double value) {
        this.result = MathOperations.add(this.result, value);
    }

    public void subtract(double value) {
        this.result = MathOperations.subtract(this.result, value);
    }

    public void multiply(double value) {
        this.result = MathOperations.multiply(this.result, value);
    }

    public void divide(double value) {
        this.result = MathOperations.divide(this.result, value);
    }

    public void power(double exponent) {
        this.result = MathOperations.power(this.result, exponent);
    }

    public void squareRoot() {
        this.result = MathOperations.squareRoot(this.result);
    }

    public void calculateExpression(String expression) {
        // Простой парсер выражений (только для демонстрации)
        if (expression.contains("+")) {
            String[] parts = expression.split("\\+");
            double a = Double.parseDouble(parts[0].trim());
            double b = Double.parseDouble(parts[1].trim());
            this.result = MathOperations.add(a, b);
        } else if (expression.contains("-")) {
            String[] parts = expression.split("-");
            double a = Double.parseDouble(parts[0].trim());
            double b = Double.parseDouble(parts[1].trim());
            this.result = MathOperations.subtract(a, b);
        } else {
            throw new IllegalArgumentException("Unsupported expression format");
        }
    }
}