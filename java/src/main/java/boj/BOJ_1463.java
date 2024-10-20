package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (N <= 3) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[N+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i <= N; i++) {
            int halfValue = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                halfValue = dp[i/2];
            }
            int byThirdValue = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                 byThirdValue = dp[i/3];
            }
            dp[i] = Math.min(Math.min(halfValue, byThirdValue), dp[i-1]) + 1;
        }

        System.out.println(dp[N]);
    }

}
