/*
Strict Pandigital Array Validator

Description: Verify if an array of 9 integers contains every digit from 1 to 9 exactly once.
Concepts: Arrays, Loops, if statements
Algorithm:


Initialize a frequency tracking array or boolean array of size 10 (seen).
Loop through the given array of size 9.
Use an if statement to check if elements are between 1 and 9 and have not been seen (seen[val] == false).
Mark as seen. If a duplicate or out-of-range number is found, flag as invalid.
*/

package deloitte.vilt.practice;

public class q9 {
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9, 3, 6, 8, 2, 5};

        boolean[] seen = new boolean[10];

        boolean isValid = true;

        for (int i = 0; i < arr.length; i++) {

            int value = arr[i];

            if (value < 1 || value > 9 || seen[value]) {
                isValid = false;
                break;
            }

            seen[value] = true;
        }

        if (isValid && arr.length == 9) {
            System.out.println("Valid Pandigital Array");
        } else {
            System.out.println("Invalid Pandigital Array");
        }
    }
}