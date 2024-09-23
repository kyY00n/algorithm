package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {

    /**
     * You would select or not select a sticker.
     * private static int[][] dp;
     * ith row jth col 0 -> not selected
     * 만약 선택하면, 옆에 있는 애를 더할 수 없음
     * dp[i][j][1] = max(dp[i][j-1][0], max(dp[i^1][j-1][0], dp[i^1][j-1][1])) + score[i][j]
     * 만약 선택하지 않으면 옆에 있는 애도 더할 수 있음
     * 1. 옆에꺼 포함하기
     * 2. 포함하지 않기 -> dp[i][j][1] - score[i][j]
     * dp[i][j][0] = max(dp[i][j][1] - score[i][j], dp[i][j-1][1])
     */

    private static int[][] score;
    private static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            score = new int[2][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                score[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                score[1][i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[2][n][2];
            System.out.println(maxScore(n));
        }
    }

    private static int maxScore(int n) {
        dp[0][0][0] = dp[1][0][0] = 0;
        dp[0][0][1] = score[0][0];
        dp[1][0][1] = score[1][0];

        for(int col = 1; col < n; col++) {
            for(int row = 0; row < 2; row++) {
                dp[row][col][1] = Math.max(dp[row][col-1][0], Math.max(dp[row^1][col-1][0], dp[row^1][col-1][1])) + score[row][col];
                dp[row][col][0] = Math.max(dp[row][col][1] - score[row][col], dp[row][col-1][1]);
            }
        }
        return Math.max(dp[0][n-1][0], Math.max(dp[0][n-1][1], Math.max(dp[1][n-1][0], dp[1][n-1][1])));
    }

}

