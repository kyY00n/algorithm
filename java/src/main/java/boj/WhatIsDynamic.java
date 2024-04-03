package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/14494
public class WhatIsDynamic {

    private static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }

        BigInteger mod = new BigInteger(Integer.toString(MOD));

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                BigInteger right = new BigInteger(Integer.toString(dp[i - 1][j]));
                BigInteger under = new BigInteger(Integer.toString(dp[i][j - 1]));
                BigInteger across = new BigInteger(Integer.toString(dp[i - 1][j - 1]));
                BigInteger sum = right.add(under).add(across);
                dp[i][j] = sum.mod(mod).intValue();
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }

}
