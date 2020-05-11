import java.util.Objects;

/*
Rational numbers should be stored in reduced form with any negative sign stored only on the numerator (i.e. the denominator must be positive).
Your toString method should omit denominators of 1. You will need to include methods for add, subtract, multiply, and divide.  Use your class to build a
simple text-based calculator for Rational Numbers. Your calculator should accept commands to give help (i.e. list valid commands and give usage information),
clear the current accumulator, set the accumulator to a new value, negate the accumulator, add, subtract, multiply or divide, the accumulator by a given
rational number. The accumulator should start at 0 and be printed after each command. Rational numbers should be able to be entered with our without a
denominator and with or without spaces around the slash. For example 4/5, 11, 4 / 1, and 13 / 5 are valid while 5 5, and 5/0 are not.
*/
public class RationalNumber {


    private int numerator;
    private int denominator;

    // constructor method that throws an exception when the denominator is zero. if the denominator is negative the "-" sign will be assigned to the numerator.
    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplestForm();

    }

    public RationalNumber(RationalNumber x) {
        this(x.numerator, x.denominator);
    }

    // constructor call for numerator 0 and denominator 1
    public RationalNumber() {
        this(0, 1);
    }


    // accessor that gets the denominator value
    public int getDenominator() {
        return denominator;
    }

    // accessor that gets the numerator value
    public int getNumerator() {
        return numerator;
    }

    // toString method call to return just the numerator while the denominator is 1 and the string version of the rational number "3/5"
    public String toString() {
        if (denominator == 1) {
            return numerator + " ";
        } else
            return numerator + " / " + denominator;
    }

    // the greatest common divisor is based on Euclid's theorem.
    public int greatestCommonDivisor(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        } else
            return greatestCommonDivisor(number2, number1 % number2);
    }

    // this method reduces the rational number to its simplest form.
    public void simplestForm() {
        if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
        int commonDivisor = greatestCommonDivisor(numerator, denominator);
        numerator = numerator / commonDivisor;
        denominator = denominator / commonDivisor;

    }

    /* this method is to add rational numbers. The basic principle behind is to to multiply the numerators with the denominator and simply multiply both the
    denominators with each other.
     */
    public RationalNumber add(RationalNumber value) {
        return new RationalNumber(numerator * value.denominator + value.numerator * denominator, denominator * value.denominator);
    }
    //the subtract method will take the same principle as the above but instead of adding the numbers we will subtract them.

    public RationalNumber subtract(RationalNumber value) {
        return new RationalNumber(numerator * value.denominator - value.numerator * denominator, denominator * value.denominator);
    }

    // to multiply the rational numbers we will simply multiply the numerators and denominators.

    public RationalNumber multiply(RationalNumber value) {
        return new RationalNumber(numerator * value.numerator, denominator * value.denominator);
    }

    // to divide the rational numbers we will multiply the rational number with the reciprocal of one of the rational number.

    public RationalNumber divide(RationalNumber value) {
        return new RationalNumber(numerator * value.denominator, denominator * value.numerator);
    }
}


