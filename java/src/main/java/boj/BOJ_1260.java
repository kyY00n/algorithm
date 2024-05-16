package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

    private static int N;
    private static boolean[][] adjMat;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjMat = new boolean[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjMat[u-1][v-1] = adjMat[v-1][u-1] = true;
        }

        visited = new boolean[N];

        dfs(V-1);
        System.out.println();

        Arrays.fill(visited, false);
        bfs(V-1);
    }

    private static void dfs(int curr) {
        visited[curr] = true;
        System.out.print((curr+1) + " ");
        for(int i = 0; i < N; i++) {
            if (adjMat[curr][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            Integer polled = queue.poll();
            System.out.print((polled+1) + " ");
            for(int i = 0; i < N; i++) {
                if (adjMat[polled][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
