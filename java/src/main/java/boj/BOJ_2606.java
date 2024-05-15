package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {

    private static int N;
    private static int P;
    private static boolean[][] adjacentMatrix;
    private static boolean[] infected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        adjacentMatrix = new boolean[N][N];
        infected = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            adjacentMatrix[c1 - 1][c2 - 1] = true;
            adjacentMatrix[c2 - 1][c1 - 1] = true;
        }
        dfs(0);
        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (infected[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int curr) {
        infected[curr] = true;
        for (int i = 0; i < N; i++) {
            if (adjacentMatrix[curr][i] && !infected[i]) {
                dfs(i);
            }
        }
    }


}
