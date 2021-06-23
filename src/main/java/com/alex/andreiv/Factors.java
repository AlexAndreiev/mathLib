package com.alex.andreiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import static com.alex.andreiv.Utils.*;

public class Factors {

    public static List<Integer> getFactors(int number){
        var factorsList = new ArrayList<Integer>();
        if (number == 0) return factorsList;

        factorsList.add(1);
        if (number == 1) return factorsList;

        var tmpNumber = number;
        var divider = 2;
        while (divider <= tmpNumber/2) {
            if (isDividerFor(divider, tmpNumber))
                factorsList.add(divider);
            divider++;
        }

        factorsList.add(number);
        return factorsList;
    }

    /*
    * Simple optimized school algorithm
    * */
    public static List<Integer> getPrimeFactors(int number, boolean isFullList){
        var primeFactorsList = new ArrayList<Integer>();
        //optimization
        if (isPrime(number)) {
            primeFactorsList.add(number);
            return primeFactorsList;
        }

        var primeGenerator = new PrimeGenerator();
        var prime = primeGenerator.getNextPrime();

        while (number >= prime) {
            if (isDividerFor(prime, number)) {
                number /= prime;
                primeFactorsList.add(prime);
                if (isFullList)
                    primeGenerator.reset();
            }
            prime = primeGenerator.getNextPrime();
        }
        return primeFactorsList;
    }

    public static List<Integer> getCommonFactors(int[] numbers) {
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
            if (!isDividerFor(divider, num))
                return false;
        }
        return true;
    }

    public static int getMaxCommonDivider(int[] numbers) {
//        Щоб знайти НСД двох чисел:
//        1) розкладіть дані числа на прості множники;
//        2) знайдіть добуток спільних дільників даних чисел.
        return 0;
    }

}
