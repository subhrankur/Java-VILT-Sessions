/*
Basic Byte Array XOR Cipher

Description: Implement a simple encryption routine using an array of bytes representing text and a single-byte key. Use a switch statement to handle different operational modes: 1 for encrypt, 2 for decrypt, 3 for brute-force mode search.
Concepts: Arrays, Loops, switch statements
Algorithm:


Define a byte array for data and a key.
Read mode choice into a switch statement.
Inside the switch cases, use a for loop to iterate through the array applying the XOR operator (data[i] ^ key).
Print the resulting transformed byte array.
*/

package deloitte.vilt.practice;

import java.util.Scanner;

public class q19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte[] data = {72, 69, 76, 76, 79};

        byte key = 42;

        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. Brute-force mode search");
        System.out.print("Enter mode: ");

        int mode = scanner.nextInt();

        switch (mode) {

            case 1:
                for (int i = 0; i < data.length; i++) {
                    data[i] = (byte) (data[i] ^ key);
                }

                System.out.println("Encrypted bytes:");
                for (byte value : data) {
                    System.out.print(value + " ");
                }
                System.out.println();
                break;

            case 2:
                for (int i = 0; i < data.length; i++) {
                    data[i] = (byte) (data[i] ^ key);
                }

                System.out.println("Decrypted text:");
                for (byte value : data) {
                    System.out.print((char) value);
                }
                System.out.println();
                break;

            case 3:
                System.out.println("Brute-force results:");

                for (int possibleKey = 0; possibleKey <= 255; possibleKey++) {

                    System.out.print("Key " + possibleKey + ": ");

                    for (int i = 0; i < data.length; i++) {
                        byte decryptedByte = (byte) (data[i] ^ possibleKey);

                        System.out.print((char) decryptedByte);
                    }

                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid mode.");
        }

        scanner.close();
    }
}