package deloitte.vilt.string_manipulations;

public class challenge05 {
    static Character firstNonRepeating(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        int[] frequency = new int[256];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == ' ') {
                continue;
            }

            ch = Character.toLowerCase(ch);
            frequency[ch]++;
        }

        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);

            if (originalChar == ' ') {
                continue;
            }

            char ch = Character.toLowerCase(originalChar);

            if (frequency[ch] == 1) {
                return originalChar;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("swiss"));
        System.out.println(firstNonRepeating("programming"));
        System.out.println(firstNonRepeating("aabbcc"));
        System.out.println(firstNonRepeating("Java"));
    }
}