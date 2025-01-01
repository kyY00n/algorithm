package leetcode;

public class LeetCode_1422 {

    public int maxScore(String s) {
        int[] zeros = new int[s.length()];
        int[] ones = new int[s.length()];

        char[] chars = s.toCharArray();

        if (chars[0] == '0') {
            zeros[0] = 1;
        }
        if (chars[s.length() - 1] == '1') {
            ones[s.length() - 1] = 1;
        }
        for(int i = 1; i < s.length(); i++) {
            zeros[i] = zeros[i-1];
            if (chars[i] == '0') {
                zeros[i]++;
            }

            ones[s.length() - 1 - i] = ones[s.length() - i];
            if (chars[s.length() - 1 - i] == '1') {
                ones[s.length() - 1 - i]++;
            }
        }

        int answer = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            int sum = zeros[i] + ones[i+1];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    // Approach 2: Count Left Zeros and Right Ones
    public int maxScore_approach2(String s) {
        int ones = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int zeros = 0;
        int ans = 0;

        // we have to stop at s.length() - 1 because left and right strings are not empty string.
        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            ans = Math.max(ans, ones+zeros);
        }

        return ans;
    }
}
