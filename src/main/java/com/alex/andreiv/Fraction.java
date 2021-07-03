package com.alex.andreiv;

import lombok.Getter;

@Getter
public class Fraction implements Comparable<Fraction> {

//    private byte sign = 1;
    private long numerator = 0;
    private long denominator = 0;

    public Fraction(long numerator, long denominator) {
        if (numerator == 0 || denominator == 0)
            throw new IllegalArgumentException("numerator and denominator cannot be 0");

        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public void add(Fraction fraction) {

    }

    public void add(int number)
    {

    }

    public void subtract(Fraction fraction) {

    }

    public void subtract(int number) {

    }

    public void multiply(Fraction fraction) {

    }

    public void multiply(int number) {

    }

    public void divide(Fraction fraction) {

    }

    public void divide(int number) {

    }

    private void reduce() {
        if (numerator == 1 || denominator == 1) return;
        var gcd = Factors.getGreatestCommonDivisorEuclideanAlg(numerator, denominator);
        if (gcd == 1) return;
        numerator /= gcd;
        denominator /= gcd;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }

    @Override
    public int compareTo(Fraction fraction) {
        // due to Fraction implementation fractions is already reduced
        // 1. Find Least Common Multiple (LCM)
        var lcm = Factors.getLeastCommonMultiple(new long[] {this.denominator, fraction.denominator});
        // 2. Find additional multiplier for new denominator
        var multiplier = lcm / this.denominator;
        // 3. Since we have lcm as a new denominator, now we need to compare numerators multiplied to the multiplier.
        var res = ((this.numerator * multiplier) - (fraction.numerator * multiplier));
        // need this step due to range overflow
        if (res < 0) return -1;
        else if (res > 0) return 1;
        else return 0;
    }
}
