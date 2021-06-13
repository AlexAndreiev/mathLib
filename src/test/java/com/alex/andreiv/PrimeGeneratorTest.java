package com.alex.andreiv;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PrimeGeneratorTest extends TestCase {

    static final int[] PRIMES_SEQUENCE = new int[]{2,3,5,7,11,13,17,19,23};

    @Test
    public void testGenNext() {
        var primeGen = new PrimeGenerator();
        for (var num : PRIMES_SEQUENCE)
            Assert.assertEquals(num, primeGen.getNextPrime());
    }
}