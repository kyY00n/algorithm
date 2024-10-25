package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14494 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] D = new int[n+1][m+1];

        // initialize base cases
        Arrays.fill(D[1], 1);
        for(int i = 0; i <= n; i++) {
            D[i][1] = 1;
        }

        // D[i][j] = D[i-1][j] + D[i][j-1] + D[i-1][j-1]
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= m; j++) {
                D[i][j] = ((D[i-1][j] + D[i][j-1]) % 1_000_000_007 + + D[i-1][j-1]) % 1_000_000_007;
            }
        }

        System.out.println(D[n][m]);

    }

}
