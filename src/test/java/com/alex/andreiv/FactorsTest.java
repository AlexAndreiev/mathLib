package com.alex.andreiv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class FactorsTest {

    @Test
    void commonFactors() {
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
}