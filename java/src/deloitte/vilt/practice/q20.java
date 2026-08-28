/*
Spiral Matrix Diagonal Sum

Description: Starting with 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed. Find the sum of the numbers on the diagonals of an N×N spiral matrix generated using loops and a 2D array.
Concepts: 2D Arrays, Loops, if statements
Algorithm:


Initialize an N×N 2D integer array (e.g., 5×5).
Use loops to populate the matrix in a spiral pattern outward from the center or inward from top-left.
Use a for loop to traverse the main and secondary diagonals (i == j and i + j == N - 1).
Sum these diagonal elements and print the final result.
*/

package deloitte.vilt.practice;

public class q20 {
    public static void main(String[] args) {
        int n = 5;

        int[][] matrix = new int[n][n];

        int row = n / 2;
        int col = n / 2;

        int value = 1;

        matrix[row][col] = value;

        int step = 1;

        while (value < n * n) {

            for (int i = 0; i < step && value < n * n; i++) {
                col++;
                value++;
                matrix[row][col] = value;
            }

            for (int i = 0; i < step && value < n * n; i++) {
                row--;
                value++;
                matrix[row][col] = value;
            }

            step++;

            for (int i = 0; i < step && value < n * n; i++) {
                col--;
                value++;
                matrix[row][col] = value;
            }

            for (int i = 0; i < step && value < n * n; i++) {
                row++;
                value++;
                matrix[row][col] = value;
            }

            step++;
        }

        System.out.println("Spiral Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        int diagonalSum = 0;

        for (int i = 0; i < n; i++) {

            if (i == i) {
                diagonalSum += matrix[i][i];
            }

            if (i + i == n - 1) {
                diagonalSum += matrix[i][i];
            }
        }

        if (n % 2 == 1) {
            diagonalSum -= matrix[n / 2][n / 2];
        }

        System.out.println("Diagonal sum: " + diagonalSum);
    }
}