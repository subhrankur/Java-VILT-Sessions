/*
Digit Cancelling Fractions

Description: The fraction 49/98 is a curious fraction, as an inexperienced mathematician in an array of fractions might incorrectly think that 49/98=4/8 by cancelling the 9s. Find all non-trivial fractions less than 1 in value with two-digit numerators and denominators that satisfy this property.
Concepts: Nested Loops, if statements
Algorithm:


Use nested for loops for numerator num (10 to 99) and denominator den (num + 1 to 99).
Extract tens and units digits for both num and den.
Use if statements to check cancellation conditions (e.g., if tens of num equals units of den, check if num * den_tens == den * num_units).
Print matching fractions.
*/

package deloitte.vilt.practice;

public class q11 {
    public static void main(String[] args) {
        for (int num = 10; num <= 99; num++) {

            for (int den = num + 1; den <= 99; den++) {

                int numTens = num / 10;
                int numUnits = num % 10;

                int denTens = den / 10;
                int denUnits = den % 10;

                if (numUnits == 0 && denUnits == 0) {
                    continue;
                }

                if (numUnits == denTens && denUnits != 0) {

                    if (num * denUnits == den * numTens) {
                        System.out.println(num + "/" + den + " -> " + numTens + "/" + denUnits);
                    }
                }

                if (numTens == denUnits && denTens != 0) {

                    if (num * denTens == den * numUnits) {
                        System.out.println(num + "/" + den + " -> " + numUnits + "/" + denTens);
                    }
                }
            }
        }
    }
}