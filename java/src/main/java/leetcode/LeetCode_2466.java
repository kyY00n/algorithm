package leetcode;

public class LeetCode_2466 {

    /**
     * https://leetcode.com/problems/count-ways-to-build-good-strings/?envType=daily-question&envId=2024-12-30
     */

    private int MOD = (int) Math.pow(10, 9) + 7;
    private int[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {

        dp = new int[high + 1];
        dp[0] = 1; // 길이가 0인 문자열도 포함

        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
        }

        int answer = 0;
        for (int i = low; i <= high; i++) {
            answer = (answer + dp[i]) % MOD;
        }
        return answer;
    }

}
