/*
Array Palindrome Checker

Description: Read an array of digits representing a code. Write a program using loops and conditionals to determine if the array reads the same forwards and backwards (is a palindrome).
Concepts: Arrays, Loops, if statements
Algorithm:


Define an integer array arr.
Initialize two pointers: left = 0 and right = arr.length - 1.
Use a while loop running while left < right.
Use an if statement to check if arr[left] != arr[right]. If true, mark as "Not a Palindrome" and break.
Increment left and decrement right. If the loop finishes without breaking, it's a palindrome.
*/

package deloitte.vilt.practice;

public class q5 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 1};
        int left = 0;
        int right = arr.length - 1;

        boolean isPalindrome = true;

        while (left < right) {

            if (arr[left] != arr[right]) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        if (isPalindrome) {

            System.out.println("Palindrome");

        } else {

            System.out.println("Not a Palindrome");
        }
    }
}