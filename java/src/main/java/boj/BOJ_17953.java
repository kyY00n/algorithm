package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17953 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 한 주기의 날짜 수
        int M = Integer.parseInt(st.nextToken()); // 디저트 종류의 수
        int[][] V = new int[M][N]; // V[i][j] = i번째 디저트를 j번째 날에 먹었을 때의 만족감.
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                V[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[M][N]; // dp[i][j] 는 i를 j번째 날에 먹었을 때의 만족감
        for(int i = 0; i < M; i++) { // base case
            dp[i][0] = V[i][0];
        }
        for(int j = 1; j < N; j++) { // 날짜 별로 ㄱㄱ
            for(int i = 0; i < M; i++) { // 간식 별로 오늘 최고 만족도 계산하기
                int max = -1;
                for(int k = 0; k < M; k++) { // 전날 먹은 간식 별로 계산해보기
                    if (i == k) { // 만약 전날이랑 같은 간식을 먹었다면
                        max = Math.max(max, dp[k][j - 1] + (V[i][j] / 2));
                        continue;
                    }
                    max = Math.max(max, dp[k][j-1] + V[i][j]);
                }
                dp[i][j] = max;
            }
        }
        int answer = 0;
        for(int i = 0; i < M; i++) {
            answer = Math.max(answer, dp[i][N-1]);
        }
        System.out.println(answer);
    }

}
