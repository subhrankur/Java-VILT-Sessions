package deloitte.vilt.string_manipulations;

public class challenge03 {
    static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(input.charAt(left))
                    != Character.toLowerCase(input.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("Racecar"));
        System.out.println(isPalindrome("Madam, I'm Adam"));
        System.out.println(isPalindrome("Java"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}