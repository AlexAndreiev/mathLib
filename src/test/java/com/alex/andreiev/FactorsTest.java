package com.alex.andreiev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorsTest {

    @Test
    public void testGetCommonFactors() {
        assertThrows(NullPointerException.class, () -> Factors.getCommonFactors(null));
        assertThrows(IllegalArgumentException.class, () -> Factors.getCommonFactors(new long[] {}));

        long[] arr;
        arr = Factors.getCommonFactors(new long[] {2}).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {1, 2}, arr);

        arr = Factors.getCommonFactors(new long[] {2, 3}).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {1}, arr);

        arr = Factors.getCommonFactors(new long[] {6, 12, 24}).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {1, 2, 3, 6}, arr);

        arr = Factors.getCommonFactors(new long[] {6, 36, 75}).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {1, 3}, arr);

        arr = Factors.getCommonFactors(new long[] {6, 36, 75, 156, 45, 205, 456872, 4972, 788, 4686})
                .stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {1}, arr);
    }

    @Test
    public void testIsCommonDivisor() {
        assertThrows(NullPointerException.class, () -> Factors.isCommonDivisor(null, 2));
        assertThrows(IllegalArgumentException.class, () -> Factors.isCommonDivisor(new int[] {4, 8}, 0));

        assertTrue(Factors.isCommonDivisor(new int[]{4, 8}, 2));
        assertFalse(Factors.isCommonDivisor(new int[]{38, 13}, 2));
        assertTrue(Factors.isCommonDivisor(new int[]{48, 8}, 8));
        assertTrue(Factors.isCommonDivisor(new int[]{4, 8}, 1));

    }

    @Test
    public void testGetFactors() {
        int[] arr;
        arr = Factors.getFactors(0).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {}, arr);

        arr = Factors.getFactors(1).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1}, arr);

        arr = Factors.getFactors(3).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1, 3}, arr);

        arr = Factors.getFactors(4).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1, 2, 4}, arr);

        arr = Factors.getFactors(13).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1, 13}, arr);

        arr = Factors.getFactors(16).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1, 2, 4, 8, 16}, arr);

        arr = Factors.getFactors(287).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1, 7, 41, 287}, arr);
    }

    @Test
    public void testGetPrimeFactors() {
        long[] arr;
        arr = Factors.getPrimeFactors(8, false).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {2}, arr);
        arr = Factors.getPrimeFactors(33, false).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {3, 11}, arr);
        arr = Factors.getPrimeFactors(1987, false).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {1987}, arr);
        arr = Factors.getPrimeFactors(247693, false).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {247693}, arr);
        arr = Factors.getPrimeFactors(247694, false).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {2, 271, 457}, arr);

        // full list
        arr = Factors.getPrimeFactors(18, true).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {2, 3, 3}, arr);
        arr = Factors.getPrimeFactors(8, true).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {2, 2, 2}, arr);
        arr = Factors.getPrimeFactors(33, true).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {3, 11}, arr);
        arr = Factors.getPrimeFactors(45, true).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {3, 3, 5}, arr);
        arr = Factors.getPrimeFactors(1987, true).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {1987}, arr);
        arr = Factors.getPrimeFactors(247693, true).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {247693}, arr);
        arr = Factors.getPrimeFactors(247694, true).stream().mapToLong(i->i).toArray();
        assertArrayEquals(new long[] {2, 271, 457}, arr);

    }

    @Test
    public void testGetGreatestCommonDivisor() {
        assertThrows(NullPointerException.class, () -> Factors.getGreatestCommonDivisor(null));
        assertThrows(IllegalArgumentException.class, () -> Factors.getGreatestCommonDivisor(new long[] {}));

        long res;
        res = Factors.getGreatestCommonDivisor(new long[] {18, 45});
        assertEquals(9, res);
        res = Factors.getGreatestCommonDivisor(new long[] {50, 25, 100});
        assertEquals(25, res);
        res = Factors.getGreatestCommonDivisor(new long[] {0, 45});
        assertEquals(0, res);
    }

    @Test
    public void testGetGreatestCommonDivisorEuclidAlg() {
        assertThrows(IllegalArgumentException.class, () -> Factors.getGreatestCommonDivisorEuclidAlg(0, 2));

        int res;
        res = Factors.getGreatestCommonDivisorEuclidAlg(18, 45);
        assertEquals(9, res);
        res = Factors.getGreatestCommonDivisorEuclidAlg(50, 25);
        assertEquals(25, res);
        res = Factors.getGreatestCommonDivisorEuclidAlg(45, 45);
        assertEquals(45, res);
    }

    @Test
    public void testGetGreatestCommonDivisorEuclideanAlg() {
        assertThrows(IllegalArgumentException.class, () -> Factors.getGreatestCommonDivisorEuclideanAlg(0, 2));

        long res;
        res = Factors.getGreatestCommonDivisorEuclideanAlg(18, 45);
        assertEquals(9, res);
        res = Factors.getGreatestCommonDivisorEuclideanAlg(50, 25);
        assertEquals(25, res);
        res = Factors.getGreatestCommonDivisorEuclideanAlg(45, 45);
        assertEquals(45, res);
        res = Factors.getGreatestCommonDivisorEuclideanAlg(2, 3);
        assertEquals(1, res);
    }

    @Test
    public void testIsCoPrime() {
        assertThrows(NullPointerException.class, () -> Factors.isCoPrime(null));
        assertThrows(IllegalArgumentException.class, () -> Factors.isCoPrime(new long[] {}));

        assertTrue(Factors.isCoPrime(new long[] {44, 95}));
        assertFalse(Factors.isCoPrime(new long[] {0, 1}));
        assertFalse(Factors.isCoPrime(new long[] {6, 21}));
        assertFalse(Factors.isCoPrime(new long[] {27, 111}));
        assertFalse(Factors.isCoPrime(new long[] {36, 117}));
    }

    @Test
    public void testGetLeastCommonMultiple() {
        assertThrows(NullPointerException.class, () -> Factors.getLeastCommonMultiple(null));
        assertThrows(IllegalArgumentException.class, () -> Factors.getLeastCommonMultiple(new long[] {}));

        long res;
        res = Factors.getLeastCommonMultiple(new long[] {4, 0});
        assertEquals(0, res);

        res = Factors.getLeastCommonMultiple(new long[] {4, 6});
        assertEquals(12, res);

        res = Factors.getLeastCommonMultiple(new long[] {45, 18});
        assertEquals(90, res);

        res = Factors.getLeastCommonMultiple(new long[] {8, 21});
        assertEquals(168, res);

        res = Factors.getLeastCommonMultiple(new long[] {9, 12, 15});
        assertEquals(180, res);
    }
}