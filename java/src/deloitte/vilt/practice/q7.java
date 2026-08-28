/*
Triangular Word Analyzer

Description: Convert an array of words into numbers by alphabet position (A=1, B=2... Z=26). Use an array lookup or switch statement to calculate word values, then check if the value is a triangular number (tn=n(n+1)/2).
Concepts: Arrays, Loops, if statements
Algorithm:


Store words in a String[] array.
Loop through each word, iterate through its characters, and sum their alphabetical values (char - 'A' + 1).
For each word sum, check if it forms a triangular number by looping n from 1 until the triangular formula equals or exceeds the sum.
Use an if statement to verify equality and count valid words.
*/

package deloitte.vilt.practice;

public class q7 {
    public static void main(String[] args) {
        String[] words = {"SKY", "ABC", "HELLO", "CAT", "DOG"};

        int count = 0;

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int sum = 0;

            for (int j = 0; j < word.length(); j++) {

                char ch = word.charAt(j);

                sum += ch - 'A' + 1;
            }

            int n = 1;
            boolean isTriangular = false;

            while (n * (n + 1) / 2 <= sum) {

                int triangularNumber = n * (n + 1) / 2;

                if (triangularNumber == sum) {
                    isTriangular = true;
                    break;
                }

                n++;
            }

            if (isTriangular) {
                System.out.println(word + " = " + sum + " → Triangular Number");
                count++;
            } else {
                System.out.println(word + " = " + sum + " → Not Triangular");
            }
        }

        System.out.println("Total triangular words: " + count);
    }
}
