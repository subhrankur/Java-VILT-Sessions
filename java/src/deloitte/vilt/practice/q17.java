/*
Menu-Driven Array Operations

Description: Write a program that manages an array of fixed size. Use a switch statement inside a loop to provide a menu: (1) Find minimum, (2) Find maximum, (3) Reverse array, (4) Exit.
Concepts: Arrays, Loops, switch statements, if statements
Algorithm:


Initialize an array of integers and a while loop running a user menu prompt.
Read user choice and pass it to a switch statement.
Case 1 & 2: Loop through the array using an if condition to track min/max.
Case 3: Use a two-pointer loop to reverse array elements in-place.
Case 4: Break the loop and terminate.
*/

package deloitte.vilt.practice;

import java.util.Scanner;

public class q17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {10, 25, 7, 42, 18, 3};

        boolean running = true;

        while (running) {

            System.out.println("\n--- Array Operations Menu ---");
            System.out.println("1. Find Minimum");
            System.out.println("2. Find Maximum");
            System.out.println("3. Reverse Array");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    int min = arr[0];

                    for (int i = 1; i < arr.length; i++) {
                        if (arr[i] < min) {
                            min = arr[i];
                        }
                    }

                    System.out.println("Minimum: " + min);
                    break;

                case 2:
                    int max = arr[0];

                    for (int i = 1; i < arr.length; i++) {
                        if (arr[i] > max) {
                            max = arr[i];
                        }
                    }

                    System.out.println("Maximum: " + max);
                    break;

                case 3:
                    int left = 0;
                    int right = arr.length - 1;

                    while (left < right) {

                        int temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;

                        left++;
                        right--;
                    }

                    System.out.println("Array reversed successfully.");

                    System.out.print("Array: ");
                    for (int value : arr) {
                        System.out.print(value + " ");
                    }
                    System.out.println();

                    break;

                case 4:
                    running = false;
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }

        scanner.close();
    }
}