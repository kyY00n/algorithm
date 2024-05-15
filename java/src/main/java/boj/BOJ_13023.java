package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023 {

    private static int N;
    private static int M;
    private static List<Integer>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (dfs(i, 1)) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }

    private static boolean dfs(int curr, int depth) {
        if (depth == 5) {
            return true;
        }
        visited[curr] = true;
        for (int neighbor : adjList[curr]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, depth + 1)) {
                    return true;
                }
            }
        }
        visited[curr] = false;
        return false;
    }

}
