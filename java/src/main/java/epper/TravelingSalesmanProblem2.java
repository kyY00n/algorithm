package epper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TravelingSalesmanProblem2 {

    private static int N;
    private static int[][] W;
    private static boolean[] visited;
    private static int minCost = Integer.MAX_VALUE; // 최솟값을 전역으로 두는 것이 포인트이다.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 수
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        Arrays.fill(visited, false);

        // 비용
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(line[j]);
            }
        }

        visited[0] = true;
        backtracking(0, 1, 0);
        System.out.println(minCost);
    }

    private static void backtracking(int departure, int depth, int cost) {
        if (cost >= minCost) {
            return;
        }
        if (depth == N) {
            int costToOrigin = W[departure][0];

            // 원점으로 돌아올 수 있는지를 체크!!
            if(costToOrigin != 0) {
                minCost = Math.min(minCost, cost + costToOrigin);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            int costToI = W[departure][i];
            if (costToI != 0 && visited[i] == false) {
                visited[i] = true;
                backtracking(i, depth + 1, cost + costToI);
                visited[i] = false;
            }
        }
    }

}
