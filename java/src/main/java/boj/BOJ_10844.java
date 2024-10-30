package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10844 {

    private static int M = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(9);
            return;
        }
        int[][] dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1];
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % M;
            }
            dp[i][9] = dp[i - 1][8];
        }

        int answer = 0;
        for(int j = 1; j < 10; j++) {
            answer = (answer + dp[N][j]) % M;
        }
        System.out.println(answer);
    }

}
