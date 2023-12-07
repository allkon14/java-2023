package edu.hw2.Task1;

public record Negate(double digit) implements Expr {
    public Negate(Expr expr) {
        this(expr.evaluate());
    }

    @Override
    public double evaluate() {
        return -digit;
    }
}
