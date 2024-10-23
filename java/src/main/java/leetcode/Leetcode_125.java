package leetcode;

public class Leetcode_125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public boolean isPalindromWithoutReplace(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }

}
