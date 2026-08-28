/*
Multiples of 3 and 5

Description: If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6, and 9. The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
Concepts: Loops, if statements
Algorithm:


Initialize a variable sum to 0.
Use a for loop to iterate from 1 up to 999.
Inside the loop, use an if statement to check if the current number is divisible by 3 or 5 (i % 3 == 0 || i % 5 == 0).
If true, add the number to sum.
Print the final sum.
*/

package deloitte.vilt.practice;

public class q1 {
    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i < 1000; i++) {

            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        
        System.out.println("Sum: " + sum);
    }   
}