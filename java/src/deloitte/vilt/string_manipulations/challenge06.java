package deloitte.vilt.string_manipulations;

import java.util.HashSet;
import java.util.Set;

public class challenge06 {
    static Character firstRepeating(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);

            if (originalChar == ' ') {
                continue;
            }

            char ch = Character.toLowerCase(originalChar);

            if (seen.contains(ch)) {
                return originalChar;
            }

            seen.add(ch);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstRepeating("abcdef"));
        System.out.println(firstRepeating("hello"));
        System.out.println(firstRepeating("programming"));
        System.out.println(firstRepeating("Java"));
    }
}