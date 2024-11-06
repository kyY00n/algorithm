package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 12; i++) {
            dp[i]= dp[i-3] + dp[i-2] + dp[i-1];
        }
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }

}
