package deloitte.vilt.string_manipulations;

public class challenge09 {
    static String longestPalindromicWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return null;
        }

        String longest = null;
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

                    if (start <= end) {

                        if (isPalindrome(word, start, end)) {

                            int length = end - start + 1;

                            if (longest == null || length > longest.length()) {
                                StringBuilder cleanWord = new StringBuilder();

                                for (int j = start; j <= end; j++) {
                                    cleanWord.append(word.charAt(j));
                                }

                                longest = cleanWord.toString();
                            }
                        }
                    }

                    word.setLength(0);
                }

            } else {
                word.append(sentence.charAt(i));
            }
        }

        return longest;
    }

    static boolean isPalindrome(StringBuilder word, int start, int end) {

        while (start < end) {

            char left = Character.toLowerCase(word.charAt(start));
            char right = Character.toLowerCase(word.charAt(end));

            if (left != right) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicWord("madam racecar level"));
        System.out.println(longestPalindromicWord("Java is fun"));
        System.out.println(longestPalindromicWord("noon civic radar"));
        System.out.println(longestPalindromicWord("Madam, level! racecar."));
    }
}