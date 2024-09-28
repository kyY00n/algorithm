package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11050 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][n + 1]; // dp[i][j] represents the iCj

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            dp[i][1] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        System.out.println(dp[n][k]);
    }

}
