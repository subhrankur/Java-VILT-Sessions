package deloitte.vilt.string_manipulations;

public class challenge04 {
    static void characterFrequency(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        int[] frequency = new int[256];
        char[] order = new char[input.length()];
        int orderCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = Character.toLowerCase(input.charAt(i));

            if (ch == ' ') {
                continue;
            }

            if (frequency[ch] == 0) {
                order[orderCount] = ch;
                orderCount++;
            }

            frequency[ch]++;
        }

        for (int i = 0; i < orderCount; i++) {
            char ch = order[i];
            System.out.println(ch + " = " + frequency[ch]);
        }
    }

    public static void main(String[] args) {
        characterFrequency("Hello World");
    }
}