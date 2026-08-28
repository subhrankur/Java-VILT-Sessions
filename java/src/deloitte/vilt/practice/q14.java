/*
Command-Line Operation Switcher

Description: Simulate a basic calculator engine for engineering metrics. Given an array of operator characters (+, -, *, /) and an array of numbers, process sequential operations using a switch statement.
Concepts: Arrays, Loops, switch statements, if statements
Algorithm:


Initialize an array of numbers and an array of operator characters.
Initialize a running result with the first array element.
Loop through the remaining elements alongside the operators array.
Use a switch statement on the current operator (+, -, *, /) to perform the operation.
Include an if statement inside the division case to prevent division by zero.
*/

package deloitte.vilt.practice;

public class q14 {
    public static void main(String[] args) {
        double[] numbers = {100, 20, 5, 10, 2};

        char[] operators = {'/', '+', '*', '-'};

        double result = numbers[0];

        for (int i = 0; i < operators.length; i++) {

            switch (operators[i]) {

                case '+':
                    result = result + numbers[i + 1];
                    break;

                case '-':
                    result = result - numbers[i + 1];
                    break;

                case '*':
                    result = result * numbers[i + 1];
                    break;

                case '/':
                    if (numbers[i + 1] == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        return;
                    }

                    result = result / numbers[i + 1];
                    break;

                default:
                    System.out.println("Invalid operator: " + operators[i]);
                    return;
            }
        }

        System.out.println("Final result: " + result);
    }
    
}
