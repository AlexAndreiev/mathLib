package com.alex.andreiv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void isDividerFor() {
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
}