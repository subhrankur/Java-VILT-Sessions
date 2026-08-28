/*
Sub-string Divisibility Checker

Description: The number 1406357289 is a 0-to-9 pandigital number because it is made of each digit 0 to 9 in some order. Check an array representation of a number to see if its sub-strings meet specific divisibility rules (e.g., 2nd to 4th digits divisible by 2, 3rd to 5th divisible by 3, etc.).
Concepts: Arrays, Loops, if statements
Algorithm:


Represent the number as an integer array of size 10.
Define an array of prime divisors: [2, 3, 5, 7, 11, 13, 17].
Use a for loop from index 1 to 7 to extract 3-digit sub-numbers from the array.
Use an if statement to check if the sub-number is divisible by the corresponding prime (subNumber % primes[i-1] != 0). If any fail, flag as invalid.
*/

package deloitte.vilt.practice;

public class q16 {
    public static void main(String[] args) {
        int[] digits = {1, 4, 0, 6, 3, 5, 7, 2, 8, 9};

        int[] primes = {2, 3, 5, 7, 11, 13, 17};

        boolean isValid = true;

        for (int i = 1; i <= 7; i++) {

            int subNumber = digits[i] * 100 + digits[i + 1] * 10 + digits[i + 2];

            if (subNumber % primes[i - 1] != 0) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            System.out.println("The number satisfies all divisibility rules.");
        } else {
            System.out.println("The number does not satisfy all divisibility rules.");
        }
    }
}