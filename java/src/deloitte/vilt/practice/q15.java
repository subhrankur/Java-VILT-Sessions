/*
Integer Right Triangle Maximizer

Description: If ppp is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly 3 solutions for p = 120: {20,48,52},{24,45,51},{30,40,50}. Find the value of p≤500 for which the number of solutions is maximized.
Concepts: Loops, if statements
Algorithm:


Create an array solutions of size 501 to track solution counts per perimeter p.
Use nested loops for a and b up to 250.
Calculate c=sqrt{a^2 + b^2}​ and perimeter p=a+b+c.
Use an if statement to check if c is a whole number and p≤500. If true, increment solutions[p].
Find the index with the maximum value in the array.
*/

package deloitte.vilt.practice;

public class q15 {
    public static void main(String[] args) {
        int[] solutions = new int[501];

        for (int a = 1; a <= 250; a++) {

            for (int b = a; b <= 250; b++) {

                double c = Math.sqrt(a * a + b * b);

                if (c == (int) c) {

                    int intC = (int) c;

                    int p = a + b + intC;

                    if (p <= 500) {
                        solutions[p]++;
                    }
                }
            }
        }

        int maxSolutions = 0;
        int bestPerimeter = 0;

        for (int p = 1; p <= 500; p++) {

            if (solutions[p] > maxSolutions) {
                maxSolutions = solutions[p];
                bestPerimeter = p;
            }
        }

        System.out.println("Perimeter with maximum solutions: " + bestPerimeter);
        System.out.println("Number of solutions: " + maxSolutions);
    }
}