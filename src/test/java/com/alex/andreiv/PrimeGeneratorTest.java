package com.alex.andreiv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    static final int[] PRIMES_SEQUENCE = new int[]{2,3,5,7,11,13,17,19,23};

    @Test
    public void testGenNext() {
        var primeGen = new PrimeGenerator();
        for (var num : PRIMES_SEQUENCE)
            assertEquals(num, primeGen.getNextPrime());
    }
}