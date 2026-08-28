/*
Array Peak Element Finder

Description: An element in an array is a "peak" if it is greater than or equal to its neighbors. Given an array of integers, find and print all peak elements using conditional logic.
Concepts: Arrays, Loops, if statements
Algorithm:


Given array arr of size n.
Use a for loop from index 0 to n - 1.
Use an if-else statement to handle boundary conditions (first and last elements) versus middle elements.
Check if arr[i] is greater than or equal to adjacent elements. Print if true.
*/

package deloitte.vilt.practice;

public class q8 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 6, 2};

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                if (arr[i] >= arr[i + 1]) {
                    System.out.println("Peak element: " + arr[i]);
                }

            } else if (i == n - 1) {
                if (arr[i] >= arr[i - 1]) {
                    System.out.println("Peak element: " + arr[i]);
                }

            } else {
                if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                    System.out.println("Peak element: " + arr[i]);
                }
            }
        }
    }
}