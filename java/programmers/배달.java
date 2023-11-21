import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 배달 {

    public static void main(String[] args) {
        var 솔루션 = new 배달_solution();
        int solution = 솔루션.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}},
                3);
        System.out.println(solution);
    }
}

class 배달_solution {
    private int[][] graph;
    public int solution(int N, int[][] road, int K) {
        graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for(var r: road) {
            int a = r[0] - 1;
            int b = r[1] - 1;
            int c = r[2];

            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            if (graph[0][i] != Integer.MAX_VALUE) {
                q.offer(new int[]{0, i});
            }
        }


        while(!q.isEmpty()) {
            int[] polled = q.poll();
            int start = polled[0], end = polled[1];
            for(int i = 0; i < N; i++) {
                if(i == start) {
                    continue;
                }
                if (graph[end][i] != Integer.MAX_VALUE) {
                    int newDist = graph[start][end] + graph[end][i];
                    if (graph[start][i] > newDist) {
                        graph[start][i] = newDist;
                        graph[i][start] = newDist;
                        // System.out.println("graph[" + start + "][" + i + "] = " + graph[start][i]);
                        q.offer(new int[]{start, i});
                    }

                }
            }
        }


        int answer = 0;

        for(int i = 0; i < N; i++) {
            if (graph[0][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
