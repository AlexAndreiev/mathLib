package com.alex.andreiv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorsTest {

    @Test
    void getCommonFactors() {
        assertThrows(NullPointerException.class, () -> Factors.getCommonFactors(null));
        assertThrows(IllegalArgumentException.class, () -> Factors.getCommonFactors(new int[] {}));

        int[] arr;
        arr = Factors.getCommonFactors(new int[] {2}).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1, 2}, arr);

        arr = Factors.getCommonFactors(new int[] {2, 3}).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1}, arr);

        arr = Factors.getCommonFactors(new int[] {6, 12, 24}).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1, 2, 3, 6}, arr);

        arr = Factors.getCommonFactors(new int[] {6, 36, 75}).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1, 3}, arr);

        arr = Factors.getCommonFactors(new int[] {6, 36, 75, 156, 45, 205, 456872, 4972, 788, 4686}).stream().mapToInt(i->i).toArray();;
        assertArrayEquals(new int[] {1}, arr);
    }

    @Test
    void isCommonDivider() {
        assertThrows(NullPointerException.class, () -> Factors.isCommonDivider(null, 2));
        assertThrows(IllegalArgumentException.class, () -> Factors.isCommonDivider(new int[] {4, 8}, 0));

        assertTrue(Factors.isCommonDivider(new int[]{4, 8}, 2));
        assertFalse(Factors.isCommonDivider(new int[]{38, 13}, 2));
        assertTrue(Factors.isCommonDivider(new int[]{48, 8}, 8));
        assertTrue(Factors.isCommonDivider(new int[]{4, 8}, 1));

    }

    @Test
    void getFactors() {
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
    void getPrimeFactors() {
        int[] arr;
        arr = Factors.getPrimeFactors(8, false).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {2}, arr);
        arr = Factors.getPrimeFactors(33, false).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {3, 11}, arr);
        arr = Factors.getPrimeFactors(1987, false).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1987}, arr);
        arr = Factors.getPrimeFactors(247693, false).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {247693}, arr);
        arr = Factors.getPrimeFactors(247694, false).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {2, 271, 457}, arr);

        // full list
        arr = Factors.getPrimeFactors(18, true).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {2, 3, 3}, arr);
        arr = Factors.getPrimeFactors(8, true).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {2, 2, 2}, arr);
        arr = Factors.getPrimeFactors(33, true).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {3, 11}, arr);
        arr = Factors.getPrimeFactors(45, true).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {3, 3, 5}, arr);
        arr = Factors.getPrimeFactors(1987, true).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {1987}, arr);
        arr = Factors.getPrimeFactors(247693, true).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {247693}, arr);
        arr = Factors.getPrimeFactors(247694, true).stream().mapToInt(i->i).toArray();
        assertArrayEquals(new int[] {2, 271, 457}, arr);

    }

    @Test
    void getMaxCommonDivider() {
        assertThrows(NullPointerException.class, () -> Factors.getMaxCommonDivider(null));
        assertThrows(IllegalArgumentException.class, () -> Factors.getMaxCommonDivider(new int[] {}));

        int res;
        res = Factors.getMaxCommonDivider(new int[] {18, 45});
        assertEquals(9, res);
        res = Factors.getMaxCommonDivider(new int[] {50, 25, 100});
        assertEquals(25, res);
        res = Factors.getMaxCommonDivider(new int[] {0, 45});
        assertEquals(0, res);


    }

}