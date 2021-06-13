package com.alex.andreiv;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Factors {


    public static List<Integer> commonFactors(int[] numbers) {
        Objects.requireNonNull(numbers, "`numbers` parameter cannot be null");

        var factorsList = new ArrayList<Integer>();
        for (int num : numbers) {
            while (num != 1)
            {

            }
        }
        return factorsList;
    }

    public static boolean isCommonDivider(int[] numbers, int divider) {
        Objects.requireNonNull(numbers, "`numbers` parameter cannot be null");
        if (divider == 0) throw new IllegalArgumentException("`divider` parameter cannot be 0");

        for (var num : numbers) {
            if (num % divider != 0)
                return false;
        }
        return true;
    }
}
