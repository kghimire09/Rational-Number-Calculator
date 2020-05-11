/*
Rational numbers should be stored in reduced form with any negative sign stored only on the numerator (i.e. the denominator must be positive).
Your toString method should omit denominators of 1. You will need to include methods for add, subtract, multiply, and divide.  Use your class to build a
simple text-based calculator for Rational Numbers. Your calculator should accept commands to give help (i.e. list valid commands and give usage information),
clear the current accumulator, set the accumulator to a new value, negate the accumulator, add, subtract, multiply or divide, the accumulator by a given
rational number. The accumulator should start at 0 and be printed after each command. Rational numbers should be able to be entered with our without a
denominator and with or without spaces around the slash. For example 4/5, 11, 4 / 1, and 13 / 5 are valid while 5 5, and 5/0 are not.
*/

import java.util.*;

public class Calculator {


    public static void main(String[] args) {
        help();
        Scanner console = new Scanner(System.in);
        while(true) {
            RationalNumber num1 = userEntry();
            RationalNumber num2 = userEntry();
            RationalNumber result = operations(console, num1, num2);
            System.out.println(result);
        }

    }
    public static void help(){
        System.out.println("This program is a calculator for Rational numbers.");
        System.out.println("What kind of operation would you like to perform?");
        System.out.println("Press + for addition.");
        System.out.println("Press - for subtraction.");
        System.out.println("Press * for multiplication.");
        System.out.println("Press / for division.");
        System.out.println("Clear the accumulator and decide a number");
    }

    public static RationalNumber userEntry() {

        System.out.print("Enter Rational Numbers: ");
        Scanner console = new Scanner(System.in);
        int numerator = 0;
        int denominator = 1;
        String line = "";

        if (console.hasNextLine()) {
            line = console.nextLine();
            Scanner cin = new Scanner(line);
            cin.useDelimiter("\\s*/\\s*");

            if (cin.hasNext()) {
                numerator = cin.nextInt();
                if(!cin.hasNext()){
                    denominator = 1;
                }else
                denominator = cin.nextInt();
            }
        }

        return new RationalNumber(numerator, denominator);
    }

public static RationalNumber operations(Scanner entry, RationalNumber num1, RationalNumber num2) {
    System.out.print("Please enter the operand: ");
    String ops = entry.next();
    if (ops.equals("+")) {
        return add1(num1, num2);
    } else if (ops.equals("-")) {
        return subtract1(num1, num2);
    } else if (ops.equals("*")) {
        return multiply1(num1, num2);
    } else
        return divide1(num1, num2);
}

    public static RationalNumber add1(RationalNumber num1, RationalNumber num2) {
        return num1.add(num2);
    }

    public static RationalNumber subtract1(RationalNumber num1, RationalNumber num2) {
        return num1.subtract(num2);

    }

    public static RationalNumber multiply1(RationalNumber num1, RationalNumber num2) {
        return num1.multiply(num2);

    }

    public static RationalNumber divide1(RationalNumber num1, RationalNumber num2) {
        return num1.divide(num2);

    }
    
    public static RationalNumber divide2(RationalNumber num1, RationalNumber num2){
        return num1.multiply(num2);
    }
}