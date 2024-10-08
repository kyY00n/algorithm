package leetcode.leetcode_1071;

public class Leetcode_1071 {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        int min = Math.min(a, b);
        int answer = 1;
        for(int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                answer = i;
            }
        }
        return answer;
    }

}
