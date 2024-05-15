package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21938 {

    private static int[][] color;
    private static int T;
    private static int N;
    private static int M;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0, 1, -1, 0};
    private static int[] dy = new int[]{1, 0, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        color = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                color[i][j] = (R + G + B) / 3;
            }

        }
        T = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && is255(i, j)) {
                    answer++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean is255(int i, int j) {
        return color[i][j] > T;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            if (0 <= newX && newX < N && 0 <= newY && newY < M && !visited[newX][newY] && is255(newX, newY)) {
                dfs(newX, newY);
            }
        }
    }

}
