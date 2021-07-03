package com.alex.andreiv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    public void testReduce() {
        var fraction = new Fraction(4, 8);
        assertEquals(fraction.getNumerator(), 1);
        assertEquals(fraction.getDenominator(), 2);

        fraction = new Fraction(9, 16);
        assertEquals(fraction.getNumerator(), 9);
        assertEquals(fraction.getDenominator(), 16);
    }

    @Test
    void testAdd() {
    }

    @Test
    void testSubtract() {
    }

    @Test
    void testDivide() {
    }

    @Test
    void testCompareTo() {

    }
}