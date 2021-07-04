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
        var fraction1 = new Fraction(1, 5);
        var fraction2 = new Fraction(3, 15);
        assertTrue(fraction1.compareTo(fraction2) == 0);

        fraction1 = new Fraction(1, 6);
        fraction2 = new Fraction(5, 18);
        assertTrue(fraction1.compareTo(fraction2) < 0);

        fraction1 = new Fraction(3, 5);
        fraction2 = new Fraction(4, 15);
        assertTrue(fraction1.compareTo(fraction2) > 0);

        fraction1 = new Fraction(7, 9);
        fraction2 = new Fraction(11, 24);
        assertTrue(fraction1.compareTo(fraction2) > 0);

        fraction1 = new Fraction(11, 21);
        fraction2 = new Fraction(17, 28);
        assertTrue(fraction1.compareTo(fraction2) < 0);

        fraction1 = new Fraction(31, 40);
        fraction2 = new Fraction(18, 35);
        assertTrue(fraction1.compareTo(fraction2) > 0);

        fraction1 = new Fraction(5, 9);
        fraction2 = new Fraction(12, 39);
        assertTrue(fraction1.compareTo(fraction2) > 0);
    }
}