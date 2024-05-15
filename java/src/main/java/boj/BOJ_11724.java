package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724 {

    private static int[][] adjacentMatrix;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjacentMatrix = new int[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacentMatrix[u-1][v-1] = 1;
            adjacentMatrix[v-1][u-1] = 1;
        }

        visited = new boolean[N];

        int count = 0;
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int start) {
        visited[start] = true;
        for(int i = 0; i < adjacentMatrix[start].length; i++) {
            if(adjacentMatrix[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}
