package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] C = new int[M+1][M+1];
            for (int i = 1; i <= M; i++) {
                C[i][0] = C[i][i] = 1;
                C[i][1] = i;
            }
            for (int i = 2; i <= M; i++) {
                for (int j = 1; j <= i; j++) {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }

            System.out.println(C[M][N]);
        }
    }


}
