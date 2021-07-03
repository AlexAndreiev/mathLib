package com.alex.andreiv;

public class Utils {

    public static boolean isDivisorFor(long divider, long number) {
        if (divider == 0)
            throw new ArithmeticException("divider can't be 0");
        if (number == 0) return false;
        return number % divider == 0;
    }

/*
     All primes are of form 6k+i for some integer k and for i = -1,0,1,2,3,4.
     2 divides (6k+0), (6k+2), (6k+4)
     3 divides (6k+3)
     check if n is divisible by 2 or 3, then to check through all the numbers of form 6k+-1;
*/
    public static boolean isPrime(long number)
    {
        if (number <= 1) return false;
        if (number <= 3) return true;

        // we can skip middle five numbers in below loop
        if (number % 2 == 0 || number % 3 == 0) return false;

/*
         if a number n is not prime, it can be factored into two factors a and b
         n = a * b
         a and b can't be both greater than the square of n,
         since then the product a*b would be greater than sqrt(n)*sqrt(n) = n
         So in any factorization of n, at least one of the factors must be smaller than the square root of n
         if we can't find any factors less than or equal to the square root, n must be a prime
*/
/*
         for better understanding
        for (int k = 1; 6*k <= Math.sqrt(number); k ++)
            if (number % (6*k-1) == 0 || number % (6*k+1) == 0) return false;
*/
        for (int i = 5; i * i <= number; i += 6)
            if (number % i == 0 || number % (i+2) == 0) return false;

        return true;
    }

    public static long getNumbersProduct(long[] numbers){
        long result = 1;
        for (var num : numbers) {
            result *= num;
            if (result == 0)
                return 0;
        }
        return result;
    }
}
