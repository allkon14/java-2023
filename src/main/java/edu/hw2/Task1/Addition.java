package edu.hw2.Task1;

public record Addition(double digit1, double digit2) implements Expr {
    public Addition(Expr expr1, Expr expr2) {
        this(expr1.evaluate(), expr2.evaluate());
    }

    @Override
    public double evaluate() {
        return digit1 + digit2;
    }

    @Override
    public String toString() {
        return this.digit1 + " + " + this.digit2 + " = " + this.evaluate();
    }
}

