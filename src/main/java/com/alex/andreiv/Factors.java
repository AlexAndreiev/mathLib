package com.alex.andreiv;

import java.util.*;

import static com.alex.andreiv.Utils.*;

public class Factors {

    public static List<Integer> getFactors(int number){
        var factorsList = new ArrayList<Integer>();
        if (number == 0) return factorsList;

        factorsList.add(1);
        if (number == 1) return factorsList;
        if (!isPrime(number)) {
            var tmpNumber = number;
            var divider = 2;
            while (divider <= tmpNumber / 2) {
                if (isDividerFor(divider, tmpNumber))
                    factorsList.add(divider);
                divider++;
            }
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
        var factorsList = new ArrayList<Integer>();
        var len = numbers.length;
        var minNumber = numbers[0];
        var hasPrimeNumber = false;
        for (var num : numbers) {
            if (num == 0) return factorsList;
            if (isPrime(num)) {
                hasPrimeNumber = false;
                minNumber = num;
                break;
            }
            if (minNumber > num) minNumber = num;
        }

        factorsList.add(1);
        if (minNumber == 1) return factorsList;

        int i;
        if (!hasPrimeNumber) {
            var divider = 2;
            while (divider <= minNumber / 2) {
                i = 0;
                while (i < len) {
                    if (!isDividerFor(divider, numbers[i]))
                        break;
                    i++;
                }
                // is divider for all numbers
                if (i == len)
                    factorsList.add(divider);
                divider++;
            }
        }

        i = 0;
        while (i < len) {
            if (!isDividerFor(minNumber, numbers[i]))
                return factorsList;
            i++;
        }

        factorsList.add(minNumber);
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
