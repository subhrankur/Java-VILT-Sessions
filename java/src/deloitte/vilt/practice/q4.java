/*
Collatz Sequence Length Classifier

Description: Consider the iterative sequence defined for the set of positive integers: n→n/2 (if n is even) and n→3n+1 (if n is odd). Using a switch statement based on parity, find which starting number under 1000 produces the longest chain.
Concepts: Loops, switch statements, if statements
Algorithm:


Track maxLength = 0 and bestNumber = 0.
Loop i from 1 to 999. For each i, simulate the sequence length.
Inside the sequence loop, use a switch expression on currentNumber % 2 (0 for even, 1 for odd) to apply the appropriate rule.
Count steps until currentNumber == 1.
If the chain length is greater than maxLength, update maxLength and bestNumber.
*/

package deloitte.vilt.practice;

public class q4 {
    public static void main(String[] args) {

        int maxLength = 0;
        int bestNumber = 0;

        for (int i = 1; i < 1000; i++) {

            int currentNumber = i;
            int length = 0;

            while (currentNumber != 1) {

                switch (currentNumber % 2) {

                    case 0:
                        currentNumber = currentNumber / 2;
                        break;

                    case 1:
                        currentNumber = 3 * currentNumber + 1;
                        break;
                }

                length++;
            }
            
            if (length > maxLength) {
                maxLength = length;
                bestNumber = i;
            }
        }

        System.out.println("Number with longest chain: " + bestNumber);
        System.out.println("Longest chain length: " + maxLength);
    }   
}