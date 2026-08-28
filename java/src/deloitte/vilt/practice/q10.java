/*
Distinct Powers Generator

Description: Consider all integer combinations of a^b for 2≤a≤5 and 2≤b≤5. Store the results in an array/list, filter out duplicates using conditional checks, and count how many unique terms exist.
Concepts: Loops, Arrays, if statements
Algorithm:


Create a large enough integer array or collection to hold generated values.
Use nested for loops for a and b within the specified ranges.
Compute Math.pow(a, b).
Use an if statement to check if the result is already present in your tracking array before adding it.
Count and print the total unique entries.
*/

package deloitte.vilt.practice;

public class q10 {
    public static void main(String[] args) {
        int[] uniqueValues = new int[100];

        int uniqueCount = 0;

        for (int a = 2; a <= 5; a++) {

            for (int b = 2; b <= 5; b++) {

                int result = (int) Math.pow(a, b);

                boolean alreadyExists = false;

                for (int i = 0; i < uniqueCount; i++) {

                    if (uniqueValues[i] == result) {
                        alreadyExists = true;
                        break;
                    }
                }

                if (!alreadyExists) {
                    uniqueValues[uniqueCount] = result;
                    uniqueCount++;
                }
            }
        }

        System.out.println("Unique values:");

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(uniqueValues[i]);
        }

        System.out.println("Total unique terms: " + uniqueCount);
    }
}