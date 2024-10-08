package boj.BOJ_1256;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1256 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // DP table to store combinations
        long[][] dp = new long[N + M + 1][M + 1];

        for (int i = 0; i <= N + M; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, M); j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                // Prevent overflow for large values of K
                dp[i][j] = Math.min(dp[i][j], 1000000000L);
            }
        }

        if (dp[N + M][M] < K) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int a = N;
        int z = M;
        for (int i = 0; i < N + M; i++) {
            if (a == 0) {
                sb.append("z");
                z--;
                continue;
            }
            if (z == 0) {
                sb.append("a");
                a--;
                continue;
            }
            if (dp[a + z - 1][z] >= K) {
                sb.append("a");
                a--;
            } else {
                sb.append("z");
                K -= dp[a + z - 1][z];
                z--;
            }
        }

        System.out.println(sb.toString());
    }
}
