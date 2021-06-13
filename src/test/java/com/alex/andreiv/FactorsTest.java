package com.alex.andreiv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class FactorsTest {

    @Test
    void getCommonFactors() {
    }

    @Test
    void isCommonDivider() {
        assertThrows(NullPointerException.class, () -> Factors.isCommonDivider(null, 2));
        assertThrows(IllegalArgumentException.class, () -> Factors.isCommonDivider(new int[] {4, 8}, 0));

        assertEquals(Factors.isCommonDivider(new int[] {4, 8}, 2), true);
        assertEquals(Factors.isCommonDivider(new int[] {38, 13}, 2), false);
        assertEquals(Factors.isCommonDivider(new int[] {48, 8}, 8), true);
        assertEquals(Factors.isCommonDivider(new int[] {4, 8}, 1), true);

    }

    @Test
    void getFactors() {
    }

    @Test
    void getPrimeFactors() {
        int[] arr;
        arr = Factors.getPrimeFactors(8).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {2}, arr);
        arr = Factors.getPrimeFactors(33).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {3, 11}, arr);
        arr = Factors.getPrimeFactors(1987).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1987}, arr);
        arr = Factors.getPrimeFactors(247693).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {2}, arr);
    }

    @Test
    void getMaxCommonDivider() {
    }
}