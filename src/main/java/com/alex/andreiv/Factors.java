package com.alex.andreiv;

import java.util.*;

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
        if (numbers.length == 0) throw new IllegalArgumentException("argument has zero size");
        var resultSet = new HashSet<>(getFactors(numbers[0]));
        for (int i = 1; i < numbers.length; i++) {
            var l = getFactors(numbers[i]);
            resultSet.retainAll(l);
        }

        return new ArrayList<>(resultSet);
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
