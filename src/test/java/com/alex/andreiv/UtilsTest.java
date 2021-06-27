package com.alex.andreiv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void isDivisorFor() {
        assertThrows(ArithmeticException.class, () -> Utils.isDivisorFor(0, 123) );
        assertTrue(Utils.isDivisorFor(2, 4));
        assertTrue(Utils.isDivisorFor(9, 27));
        assertTrue(Utils.isDivisorFor(14, 28));
        assertTrue(Utils.isDivisorFor(2, 168));
        assertTrue(Utils.isDivisorFor(3, 3*56));
        assertFalse(Utils.isDivisorFor(2, 0));
        assertFalse(Utils.isDivisorFor(2, 5));
        assertFalse(Utils.isDivisorFor(3, 55));
    }

    @Test
    void isPrime() {
        assertFalse(Utils.isPrime(0));
        assertFalse(Utils.isPrime(1));
        assertTrue(Utils.isPrime(2));
        assertTrue(Utils.isPrime(3));
        assertFalse(Utils.isPrime(4));
        assertTrue(Utils.isPrime(1987));
    }

    @Test
    void getNumbersProduct() {
        long res;
        res = Utils.getNumbersProduct(new int[] {0, 2});
        assertEquals(0, res);

        res = Utils.getNumbersProduct(new int[] {2, 2});
        assertEquals(4, res);

        res = Utils.getNumbersProduct(new int[] {3, 2, 5, 7});
        assertEquals(210, res);

        res = Utils.getNumbersProduct(new int[] {78, 2, 3, 74, 231, 63, 24});
        assertEquals(12095987904L, res);
    }
}