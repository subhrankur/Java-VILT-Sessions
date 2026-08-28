package deloitte.vilt.string_manipulations;

public class challenge10 {
    static String compress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int count = 1;

        for (int i = 1; i <= input.length(); i++) {

            if (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1));
                result.append(count);

                count = 1;
            }
        }

        return result.toString();
    }

    static String decompress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < input.length()) {

            char ch = input.charAt(i);
            i++;

            int count = 0;

            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                count = count * 10 + (input.charAt(i) - '0');
                i++;
            }

            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbccccd"));
        System.out.println(compress("abcd"));
        System.out.println(compress("aaaa"));

        System.out.println();

        System.out.println(decompress("a3b2c4d1"));
        System.out.println(decompress("a1b1c1d1"));
        System.out.println(decompress("a4"));
    }
}