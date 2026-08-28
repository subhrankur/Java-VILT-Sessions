/*
Circular Prime Counter

Description: The number 197 is called a circular prime because all rotations of the digits (197, 971, 719) are themselves prime. Write a program using arrays to count how many circular primes exist below 100.
Concepts: Arrays, Loops, if statements
Algorithm:


Use a boolean array (Sieve of Eratosthenes) up to 100 to quickly look up prime numbers.
Loop through numbers from 2 to 99.
For each prime, generate its circular shifts mathematically using loops and division/modulus.
Use an if statement to check if all shifted variants are marked true in the prime array. Count matches.
*/

package deloitte.vilt.practice;

public class q12 {
    public static void main(String[] args) {
        boolean[] isPrime = new boolean[100];

        for (int i = 2; i < 100; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < 100; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j < 100; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int circularPrimeCount = 0;

        for (int number = 2; number < 100; number++) {

            if (!isPrime[number]) {
                continue;
            }

            int original = number;
            int rotated = number;
            boolean isCircularPrime = true;

            int digits = 0;
            int temp = number;

            while (temp > 0) {
                digits++;
                temp = temp / 10;
            }

            for (int i = 0; i < digits - 1; i++) {

                int lastDigit = rotated % 10;
                rotated = lastDigit * (int) Math.pow(10, digits - 1)
                        + rotated / 10;

                if (!isPrime[rotated]) {
                    isCircularPrime = false;
                    break;
                }
            }

            if (isCircularPrime) {
                System.out.println("Circular prime: " + original);
                circularPrimeCount++;
            }
        }

        System.out.println("Total circular primes below 100: " + circularPrimeCount);
    }
}