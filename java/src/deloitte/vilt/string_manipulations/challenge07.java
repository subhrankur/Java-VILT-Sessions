package deloitte.vilt.string_manipulations;

import java.util.Arrays;

public class challenge07 {
    static boolean isAnagram(String first, String second) {
        if (first == null || second == null) {
            return false;
        }

        int[] frequency = new int[256];

        int firstCount = 0;
        int secondCount = 0;

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);

            if (!Character.isLetterOrDigit(ch)) {
                continue;
            }

            ch = Character.toLowerCase(ch);
            frequency[ch]++;
            firstCount++;
        }

        for (int i = 0; i < second.length(); i++) {
            char ch = second.charAt(i);

            if (!Character.isLetterOrDigit(ch)) {
                continue;
            }

            ch = Character.toLowerCase(ch);
            frequency[ch]--;
            secondCount++;
        }

        if (firstCount != secondCount) {
            return false;
        }

        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    static boolean isAnagramUsingSorting(String first, String second) {
        if (first == null || second == null) {
            return false;
        }

        StringBuilder firstCleaned = new StringBuilder();
        StringBuilder secondCleaned = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                firstCleaned.append(Character.toLowerCase(ch));
            }
        }

        for (int i = 0; i < second.length(); i++) {
            char ch = second.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                secondCleaned.append(Character.toLowerCase(ch));
            }
        }

        if (firstCleaned.length() != secondCleaned.length()) {
            return false;
        }

        char[] firstChars = new char[firstCleaned.length()];
        char[] secondChars = new char[secondCleaned.length()];

        for (int i = 0; i < firstCleaned.length(); i++) {
            firstChars[i] = firstCleaned.charAt(i);
            secondChars[i] = secondCleaned.charAt(i);
        }

        Arrays.sort(firstChars);
        Arrays.sort(secondChars);

        for (int i = 0; i < firstChars.length; i++) {
            if (firstChars[i] != secondChars[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("triangle", "integral"));
        System.out.println(isAnagram("hello", "world"));
        System.out.println(isAnagram("Debit Card", "Bad Credit"));

        System.out.println();

        System.out.println(isAnagramUsingSorting("listen", "silent"));
        System.out.println(isAnagramUsingSorting("triangle", "integral"));
        System.out.println(isAnagramUsingSorting("hello", "world"));
        System.out.println(isAnagramUsingSorting("Debit Card", "Bad Credit"));
    }
}