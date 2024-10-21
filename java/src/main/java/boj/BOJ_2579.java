package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2579 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for(int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[300][2];
        dp[0][0] = dp[0][1] = score[0];
        dp[1][0] = score[1] + score[0];
        dp[1][1] = score[1]; // 두 칸 점프함

        // 한칸 점프: dp[i][0] = dp[i-1][1] + score[i];
        // 두칸 점프: dp[i][1] = dp[i-1][0] + score[i];

        for(int i = 2; i < n; i++) {
            dp[i][0] = dp[i-1][1] + score[i];
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][0]) + score[i];
        }

        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }

}
