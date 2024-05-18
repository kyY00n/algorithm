package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167 {

    private static int V;
    private static ArrayList<Edge>[] adj;
    private static boolean[] visited;
    private static int maxDistance;
    private static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                adj[s].add(new Edge(e, cost));
                adj[e].add(new Edge(s, cost));
            }
        }

        // 1. 임의의 정점 (여기서는 1번 정점)에서 가장 먼 정점을 찾는다.
        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(1, 0);

        // 2. 위에서 찾은 정점에서 다시 가장 먼 정점을 찾는다.
        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(maxNode, 0);

        // 3. 두 번째 찾은 최대 거리가 트리의 지름이다.
        System.out.println(maxDistance);
    }

    private static void dfs(int node, int distance) {
        visited[node] = true;
        if (distance > maxDistance) {
            maxDistance = distance;
            maxNode = node;
        }

        for (Edge edge : adj[node]) {
            if (!visited[edge.to]) {
                dfs(edge.to, distance + edge.cost);
            }
        }
    }

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
