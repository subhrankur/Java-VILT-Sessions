package deloitte.vilt.string_manipulations;

public class challenge02 {
    static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (ch != ' ') {
                word.append(ch);
            } else {
                for (int j = word.length() - 1; j >= 0; j--) {
                    result.append(word.charAt(j));
                }

                result.append(ch);

                word.setLength(0);
            }
        }

        for (int j = word.length() - 1; j >= 0; j--) {
            result.append(word.charAt(j));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("Java is fun"));
        System.out.println(reverseEachWord("Hello World"));
        System.out.println(reverseEachWord("Java"));
        System.out.println(reverseEachWord("Java  is   powerful"));
    }
}