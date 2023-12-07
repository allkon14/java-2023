package edu.hw2;

import edu.hw2.Task1.Addition;
import edu.hw2.Task1.Constant;
import edu.hw2.Task1.Exponent;
import edu.hw2.Task1.Expr;
import edu.hw2.Task1.Multiplication;
import edu.hw2.Task1.Negate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExprTest {
    @Test
    @DisplayName("Проверка всех операций")
    void checkExpr1() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        double expectedResult = 37.0;

        assertEquals(expectedResult, res.evaluate());
    }

    @Test
    @DisplayName("Проверка сложения")
    void checkExpr2() {
        var exp = new Exponent(4, 2);
        var res = new Addition(exp, new Constant(4));
        double expectedResult = 20;
        assertEquals(expectedResult, res.evaluate());
    }

    @Test
    @DisplayName("Проверка умножения")
    void checkExpr3() {
        double expectedResult = -24;
        var mul = new Multiplication(8, -3);

        assertEquals(expectedResult, mul.evaluate());

        expectedResult = 0;
        mul = new Multiplication(998, 0);
        assertEquals(expectedResult, mul.evaluate());
    }

    @Test
    @DisplayName("Проверка Exponent")
    void checkExpr4() {
        double expectedResult = 81;
        var exp = new Exponent(9, 2);
        assertEquals(expectedResult, exp.evaluate());

        expectedResult = 1. / 81;
        exp = new Exponent(9, -2);
        assertEquals(expectedResult, exp.evaluate());

    }

    @Test
    @DisplayName("Проверка Negative")
    void checkNegative(){
        double value = 5.0;
        Expr expression = new Constant(value);
        Expr negate = new Negate(expression);
        double expectedResult = -5.0;
        assertThat(negate.evaluate()).isEqualTo(expectedResult);
    }
}
