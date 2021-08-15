package com.alex.andreiev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracedExpressionTest {

    @Test
    void calculate() {
        var actual = BracedExpression.calculate("(3-1)");
        assertEquals(2, actual);

        actual = BracedExpression.calculate("(1 + ((2+3) * (4 * 5)))");
        assertEquals(101, actual);

        actual = BracedExpression.calculate("(10.5 / 0.5)");
        assertEquals(21, actual);

        actual = BracedExpression.calculate("(10 + ((10.5 / 0.5) * 3))");
        assertEquals(73, actual);

    }
}