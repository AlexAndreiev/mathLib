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
                if (isDivisorFor(divider, tmpNumber))
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
            if (isDivisorFor(prime, number)) {
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
            // if there is at lest one prime number common factor might be 1,
            // prime number and numbers for which this prime number is a factor
            if (isPrime(num)) {
                hasPrimeNumber = false;
                minNumber = num;
                break;
            }
            if (minNumber > num) minNumber = num;
        }

        factorsList.add(1);
        if (minNumber == 1) return factorsList;

        if (!hasPrimeNumber) {
            var divider = 2;
            while (divider <= minNumber / 2) {
                int finalDivider = divider;
                // is divider for all numbers
                if (Arrays.stream(numbers).allMatch(n -> isDivisorFor(finalDivider, n)))
                    factorsList.add(divider);
                divider++;
            }
        }

        int finalMinNumber = minNumber;
        if (Arrays.stream(numbers).allMatch(n -> isDivisorFor(finalMinNumber, n)))
            factorsList.add(minNumber);
        return factorsList;
    }


    public static boolean isCommonDivisor(int[] numbers, int divider) {
        Objects.requireNonNull(numbers, "`numbers` parameter cannot be null");
        if (divider == 0) throw new IllegalArgumentException("`divider` parameter cannot be 0");

        for (var num : numbers) {
            if (!isDivisorFor(divider, num))
                return false;
        }
        return true;
    }

    public static int getGreatestCommonDivisor(int[] numbers) {
        Objects.requireNonNull(numbers, "`numbers` parameter cannot be null");
        if (numbers.length == 0) throw new IllegalArgumentException("argument has zero size");

        // 1. get prime factors for each number
        var lists = new ArrayList<List<Integer>>(numbers.length);
        for (var num : numbers) {
            if (num == 0) return 0;
            var primeFactors = getPrimeFactors(num, true);
            lists.add(primeFactors);
        }
        var minList = lists.stream().min(Comparator.comparing(List::size)).get();
        var resultList = new ArrayList(minList);
        lists.remove(minList);
        for (var n : minList) {
            for (var list : lists) {
                if (!list.contains(n)) {
                    resultList.remove(n);
                    break;
                }
                list.remove(n);
            }
        }
        // 2. Result is a product of common factors
        var res = resultList.stream().mapToInt(n -> (int) n).reduce(1, (a, b) -> a * b);
        return res;
    }


    /* given two positive integers a and b such that a > b,
    * the common divisors of a and b are the same as the common divisors of a – b and b.
    * Euclid's method for computing the greatest common divisor of two positive integers consists of replacing
    * the larger number by the difference of the numbers,
    * and repeating this until the two numbers are equal: that is their greatest common divisor.
    */
    public static int getGreatestCommonDivisorEuclidAlg(int a, int b) {
        if (a <= 0  || b <= 0) throw new IllegalArgumentException("arguments should be > than zero");

        if (a == b) return a;
        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

/*
    The difference of the two numbers a and b is replaced by the remainder of the Euclidean division
    (also called division with remainder) of a by b.
    Denoting this remainder as a mod b, the algorithm replaces (a, b) by (b, a mod b) repeatedly
    until the pair is (d, 0), where d is the greatest common divisor.
*/
    public static int getGreatestCommonDivisorEuclideanAlg(int a, int b) {
        if (a <= 0  || b <= 0) throw new IllegalArgumentException("arguments should be > than zero");

        if (a == b) return a;
        while (a != 0 && b != 0) {
            if (a > b)
                a %= b;
            else
                b %= a;
        }
        return Math.max(a, b);
    }
}
