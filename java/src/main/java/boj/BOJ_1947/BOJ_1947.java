package boj.BOJ_1947;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1947 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_000 + 1];
        dp[1] = 0;
        dp[2] = 1;
        int MAX = 1_000_000_000;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = (int) ((long) ((dp[i - 2] + dp[i - 1]) % MAX) * (i - 1) % MAX);
        }
        System.out.println(dp[N]);
    }

}
