package edu.hw2.Task1;

public record Constant(double digit) implements Expr {
    @Override
    public double evaluate() {
        return digit;
    }
}
