/*
Digit Factorial Sum (Curious Numbers)

Description: Find the sum of all numbers which are equal to the sum of the factorial of their digits (e.g., 145=1!+4!+5!). Use a switch statement to return the factorial for digits 0 through 9.
Concepts: Loops, switch statements, if statements
Algorithm:


Loop through numbers from 10 to 50,000.
For each number, extract its digits using a loop.
Pass each digit into a helper function/block featuring a switch statement mapping 0–9 to their respective factorials.
Sum the factorials and use an if statement to compare with the original number. Print matches.
*/

package deloitte.vilt.practice;

public class q6 {

    public static int factorial(int digit) {

        switch (digit) {
            case 0:
                return 1;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 24;
            case 5:
                return 120;
            case 6:
                return 720;
            case 7:
                return 5040;
            case 8:
                return 40320;
            case 9:
                return 362880;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {

        for (int number = 10; number <= 50000; number++) {

            int originalNumber = number;
            int sum = 0;

            while (number > 0) {
                int digit = number % 10;

                sum += factorial(digit);

                number = number / 10;
            }

            if (sum == originalNumber) {
                System.out.println(originalNumber);
            }
        }
    }
}