package deloitte.vilt.string_manipulations;

public class challenge01 {
    static String reverseWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int end = sentence.length() - 1;

        while (end >= 0 && sentence.charAt(end) == ' ') {
            end--;
        }

        while (end >= 0) {

            int start = end;

            while (start >= 0 && sentence.charAt(start) != ' ') {
                start--;
            }

            if (result.length() > 0) {
                result.append(' ');
            }

            for (int i = start + 1; i <= end; i++) {
                result.append(sentence.charAt(i));
            }

            end = start;

            while (end >= 0 && sentence.charAt(end) == ' ') {
                end--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Java makes programming fun"));
        System.out.println(reverseWords("Hello World"));
        System.out.println(reverseWords("   Java   is   powerful   "));
        System.out.println(reverseWords("Java"));
        System.out.println(reverseWords(""));
    }
}