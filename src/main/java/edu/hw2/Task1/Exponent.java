package edu.hw2.Task1;

public record Exponent(double digit, int pow) implements Expr {
    public Exponent(Expr expr, int pow) {
        this(expr.evaluate(), pow);
    }

    @Override
    public double evaluate() {
        double res = 1;
        if (pow > 0) {
            for (int i = 1; i <= pow; i++) {
                res *= digit;
            }
        } else {
            for (int i = 0; i > pow; i--) {
                res /= digit;
            }
        }
        return res;
    }
}
