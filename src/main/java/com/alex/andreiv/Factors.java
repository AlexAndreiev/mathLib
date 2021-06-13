package com.alex.andreiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import static com.alex.andreiv.Utils.*;

public class Factors {

    public static List<Integer> getFactors(int number){
        var factorsList = new ArrayList<Integer>();
        factorsList.add(1);
        var primeGenerator = new PrimeGenerator();
        var prime = primeGenerator.getNextPrime();

        var tmpNumber = number;
        while (tmpNumber < prime) {
            if (isDividerFor(prime, tmpNumber)) {
                tmpNumber /= prime;
                primeGenerator.reset();
                factorsList.add(prime);
                continue;
            }
            prime = primeGenerator.getNextPrime();
        }



        factorsList.add(number);
        return factorsList;
    }

    public static List<Integer> getPrimeFactors(int number){
        //optimization
        if (isPrime(number))
            return number;

        var primeFactorsList = new ArrayList<Integer>();
        var primeGenerator = new PrimeGenerator();
        var prime = primeGenerator.getNextPrime();

        while (number >= prime) {
            if (isDividerFor(prime, number)) {
                number /= prime;
                primeFactorsList.add(prime);
                primeGenerator.reset();
            }
            prime = primeGenerator.getNextPrime();
        }

        return new ArrayList<>(new HashSet<>(primeFactorsList));
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
            if (num % divider != 0)
                return false;
        }
        return true;
    }

    public static int getMaxCommonDivider(int[] numbers) {
        return 0;
    }

}
