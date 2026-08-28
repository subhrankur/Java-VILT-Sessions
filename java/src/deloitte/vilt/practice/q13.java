/*
Consecutive Prime Sum Sequence

Description: Which prime below 100 can be written as the sum of the most consecutive primes? Store generated primes in an array and use nested loops to test contiguous sub-arrays.
Concepts: Arrays, Loops, if statements
Algorithm:


Generate all primes below 100 and store them in an integer array primes.
Use nested for loops to calculate cumulative sums of sub-arrays starting from index i to j.
Use an if statement to check if the cumulative sum is itself a prime (using the prime array) and if the length of the sequence is greater than the current maximum.
Track the maximum sequence length and its prime sum.
*/

package deloitte.vilt.practice;

public class q13 {
    public static void main(String[] args) {
        boolean[] isPrime = new boolean[100];

        for (int i = 2; i < 100; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < 100; i++) {

            if (isPrime[i]) {
                for (int j = i * i; j < 100; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] primes = new int[25];
        int primeCount = 0;

        for (int i = 2; i < 100; i++) {

            if (isPrime[i]) {
                primes[primeCount] = i;
                primeCount++;
            }
        }

        int maxLength = 0;
        int bestPrimeSum = 0;

        for (int i = 0; i < primeCount; i++) {

            int sum = 0;

            for (int j = i; j < primeCount; j++) {

                sum += primes[j];

                if (sum >= 100) {
                    break;
                }

                if (isPrime[sum]) {

                    int length = j - i + 1;

                    if (length > maxLength) {
                        maxLength = length;
                        bestPrimeSum = sum;
                    }
                }
            }
        }

        System.out.println("Prime with longest consecutive sum: " + bestPrimeSum);
        System.out.println("Sequence length: " + maxLength);
    }
}