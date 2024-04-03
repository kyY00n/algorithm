package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2579
public class GoUpStairs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[300];

        for(int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[300][2]; // dp[i][0]: 전전 칸에서 온 거, dp[i][1]: 전 칸에서 온거
        dp[0][0] = -1;
        dp[0][1] = score[0];
        dp[1][0] = score[1];
        dp[1][1] = score[0] + score[1];

        for(int i = 2; i < N; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + score[i];
            dp[i][1] = dp[i-1][0] + score[i];
        }
        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
    }
}
