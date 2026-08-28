/*
Prime Pair Array Evaluator

Description: Given a small array of primes, check pairs of elements (p1,p2) to see if concatenating them in any order yields a new prime number.
Concepts: Arrays, Loops, if statements
Algorithm:


Given an array of prime numbers.
Use nested for loops to select two distinct primes from the array, say p1 and p2.
Combine them mathematically or via string formatting into val1 = concat(p1, p2) and val2 = concat(p2, p1).
Use an if statement to check if both concatenated values are prime. Print valid pairs.
*/

package deloitte.vilt.practice;

public class q18 {
    public static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
    public static int concatenate(int first, int second) {

        int multiplier = 10;

        while (multiplier <= second) {
            multiplier *= 10;
        }

        return first * multiplier + second;
    }
    public static void main(String[] args) {
        int[] primes = {2, 3, 7, 13, 17, 31};

        for (int i = 0; i < primes.length; i++) {

            for (int j = i + 1; j < primes.length; j++) {

                int p1 = primes[i];
                int p2 = primes[j];

                int val1 = concatenate(p1, p2);
                int val2 = concatenate(p2, p1);

                if (isPrime(val1) && isPrime(val2)) {
                    System.out.println("Valid pair: (" + p1 + ", " + p2 + ")");
                    System.out.println(val1 + " and " + val2 + " are both prime.");
                }
            }
        }
    }
}