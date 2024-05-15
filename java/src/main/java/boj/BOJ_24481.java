package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24481 {

    private static List<Integer>[] adjList;
    private static int[] answer;
    private static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        visited = new boolean[N];
        answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u - 1].add(v - 1);
            adjList[v - 1].add(u - 1);
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 0; i < N; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(R - 1, 0);

        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int curr, int depth) {
        visited[curr] = true;
        answer[curr] = depth;
        for (int next : adjList[curr]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}
