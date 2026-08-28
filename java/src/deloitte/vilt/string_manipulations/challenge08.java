package deloitte.vilt.string_manipulations;

public class challenge08 {
    static String longestWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String longest = "";
        StringBuilder word = new StringBuilder();

        for (int i = 0; i <= sentence.length(); i++) {

            if (i == sentence.length() || sentence.charAt(i) == ' ') {

                if (word.length() > 0) {

                    int start = 0;
                    int end = word.length() - 1;

                    while (start <= end && !Character.isLetterOrDigit(word.charAt(start))) {
                        start++;
                    }

                    while (end >= start && !Character.isLetterOrDigit(word.charAt(end))) {
                        end--;
                    }

                    StringBuilder cleanWord = new StringBuilder();

                    for (int j = start; j <= end; j++) {
                        cleanWord.append(word.charAt(j));
                    }

                    if (cleanWord.length() > longest.length()) {
                        longest = cleanWord.toString();
                    }

                    word.setLength(0);
                }

            } else {
                word.append(sentence.charAt(i));
            }
        }

        return longest;
    }

    static String longestWordWithLength(String sentence) {
        String word = longestWord(sentence);

        return word + " = " + word.length();
    }

    public static void main(String[] args) {
        System.out.println(longestWord("Java is powerful"));
        System.out.println(longestWord("I love Java"));
        System.out.println(longestWord("one two six"));

        System.out.println();

        System.out.println(longestWordWithLength("Java programming language"));
    }
}