/*
Largest Digit in an Array

Description: Given an array of integers representing various sensor readings, write a program to find the largest single digit present across all numbers in the array.
Concepts: Arrays, Loops, if statements
Algorithm:


Initialize an array of integers and a variable maxDigit = 0.
Use a nested loop: outer for loop to iterate through the array elements, and an inner while loop to extract digits of each number using modulus (% 10) and division (/ 10).
Use an if statement to check if the extracted digit is greater than maxDigit. Update maxDigit if true.
Print maxDigit.
*/

package deloitte.vilt.practice;

public class q3 {
    public static void main(String[] args) {

        int[] numbers = {123, 456, 789, 102, 564};
        int maxDigit = 0;

        for (int i = 0; i < numbers.length; i++) {

            int number = numbers[i];

            while (number > 0) {

                int digit = number % 10;

                if (digit > maxDigit) {
                    maxDigit = digit;
                }

                number = number / 10;
            }
        }
        
        System.out.println("Max Digit: " + maxDigit);
    }
}