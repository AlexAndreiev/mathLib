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
    public static List<Long> getPrimeFactors(long number, boolean isFullList){
        var primeFactorsList = new ArrayList<Long>();
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

    public static List<Long> getCommonFactors(long[] numbers) {
        Objects.requireNonNull(numbers, "`numbers` parameter cannot be null");
        if (numbers.length == 0) throw new IllegalArgumentException("argument has zero size");
        var factorsList = new ArrayList<Long>();
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

        factorsList.add(1L);
        if (minNumber == 1) return factorsList;

        if (!hasPrimeNumber) {
            var divider = 2L;
            while (divider <= minNumber / 2) {
                var finalDivider = divider;
                // is divider for all numbers
                if (Arrays.stream(numbers).allMatch(n -> isDivisorFor(finalDivider, n)))
                    factorsList.add(divider);
                divider++;
            }
        }

        var finalMinNumber = minNumber;
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

    public static long getGreatestCommonDivisor(long[] numbers) {
        Objects.requireNonNull(numbers, "`numbers` parameter cannot be null");
        if (numbers.length == 0) throw new IllegalArgumentException("argument has zero size");

        // 1. get prime factors for each number
        var lists = new ArrayList<List<Long>>(numbers.length);
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
        var res = resultList.stream().mapToLong(n -> (long) n).reduce(1, (a, b) -> a * b);
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
    public static long getGreatestCommonDivisorEuclideanAlg(long a, long b) {
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

    /*
    * two integers a and b are coprime, relatively prime or mutually prime if the only positive integer
    * that is a divisor of both of them is 1
    * Consequently, any prime number that divides one of a or b does not divide the other.
    * This is equivalent to their greatest common divisor (gcd) being 1.
    * One says also a is prime to b or a is coprime with b.
    * */
    public static boolean isCoPrime(long[] numbers) {
        Objects.requireNonNull(numbers, "`numbers` parameter cannot be null");
        if (numbers.length == 0) throw new IllegalArgumentException("argument has zero size");
        var commonFactors = getCommonFactors(numbers);
        return commonFactors.size() == 1 && commonFactors.get(0) == 1;
    }
//TODO
// Lehmer's GCD algorithm
// Binary GCD algorithm

    public static long getLeastCommonMultiple(long[] numbers) {
        Objects.requireNonNull(numbers, "`numbers` parameter cannot be null");
        if (numbers.length == 0) throw new IllegalArgumentException("argument has zero size");

        /* there is no another factors for coprime numbers than 1. So LCM is their product */
        if (isCoPrime(numbers))
            return Utils.getNumbersProduct(numbers);

        /*
        * 1. Get prime factors of all numbers
        * 2. Result is a product of all distinct factors
        */
        var primeFactors = new ArrayList<List<Long>>();
        for (var num : numbers) {
            if (num == 0) return 0;
            var factors = getPrimeFactors(num, true);
            primeFactors.add(factors);
        }

        for (int i = 0; i < primeFactors.size(); i++) {
            for (var factor : primeFactors.get(i)) {
                for (int j = i + 1; j < primeFactors.size(); j++)
                {
                    var list = primeFactors.get(j);
                    if (list.contains(factor))
                        list.remove(factor);
                }
            }
        }

        long result = 1;
        for (var list : primeFactors)
            result *= Utils.getNumbersProduct(list.stream().mapToLong(i -> i).toArray());
        return result;
    }

}
