package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

    private static int[] T;
    private static int[] P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2]; // 주목~ 여기 +2 를해야함. 왜냐면 퇴사날 다음까지 돈을 계산해야하니까.

        // dp[i]는 i번째 날부터 퇴사날까지 번 돈
        for (int i = N; i > 0; i--) {
            if (i + T[i] <= N + 1) { // 오늘 받은 일을 퇴사날 전까지 할 수 있는지 확인
                dp[i] = P[i] + dp[i + T[i]];
            }
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.println(dp[1]);
    }

}
