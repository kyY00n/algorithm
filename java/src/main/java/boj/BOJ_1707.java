package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) { // 테스트케이스 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Integer>[] adjList = new ArrayList[V];
            for (int j = 0; j < V; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adjList[u - 1].add(v - 1);
            }

            System.out.println(isBipartite(adjList) ? "YES" : "NO");

        }
    }

    private static boolean isBipartite(List<Integer>[] adjList) {
        boolean[] visited = new boolean[adjList.length];


        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            Integer polled = queue.poll();
            List<Integer> adjNodes = adjList[polled];
            for(int adjNode: adjNodes) {
                if(!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.add(adjNode);
                }
            }
        }

        // 다 이어져 있는 경우 false 반환
        boolean check = false;
        for(boolean v: visited) {
            if (!v) {
                check = true;
            }
        }
        if (!check) {
            System.out.println("하나예요");
            return false;
        }


        for(int i = 1; i < adjList.length; i++) {
            if (!visited[i]) {
                Queue<Integer> queue2 = new ArrayDeque<>();
                queue.add(i);

                while(!queue2.isEmpty()) {
                    Integer polled = queue2.poll();
                    List<Integer> adjNodes = adjList[polled];
                    for(int adjNode: adjNodes) {
                        if(!visited[adjNode]) {
                            visited[adjNode] = true;
                            queue.add(adjNode);
                        }
                    }
                }
                break;
            }
        }

        for (boolean v: visited) {
            if (!v) {
                System.out.println("여러개예요");
                return false;
            }
        }

        return true;
    }

}
