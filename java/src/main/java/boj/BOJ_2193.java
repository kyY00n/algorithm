package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2193 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        long[][] dp = new long[N + 1][2];
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            // 1을 붙이는 경우
            dp[i][1] = dp[i - 1][0];
            // 0을 붙이는 경우
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        }
        System.out.println(dp[N][0] + dp[N][1]);
    }

}
