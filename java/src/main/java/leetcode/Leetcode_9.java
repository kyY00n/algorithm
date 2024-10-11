package leetcode;

public class Leetcode_9 {
    public boolean isPalindrome(int x) {
        String s = x + "";
        char[] chars = s.toCharArray();
        int p1 = 0;
        int p2 = chars.length - 1;
        while(p1 <= p2) {
            if (chars[p1] != chars[p2]) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }
}
