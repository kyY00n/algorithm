package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10026 {

    public static final char R = 'R';
    public static final char G = 'G';
    public static int N;

    private static char[][] colors;
    public static boolean[][] visited;
    public static int[] dx = new int[]{0, 1, -1, 0};
    public static int[] dy = new int[]{1, 0, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        colors = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            colors[i] = br.readLine().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        System.out.print(cnt + " ");
        cnt = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    dfsForBlind(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            if (0 <= newX && newX < N && 0 <= newY && newY < N
                    && !visited[newX][newY] && isSame(colors[x][y], colors[newX][newY], false)) {

                dfs(newX, newY);
            }
        }
    }

    private static void dfsForBlind(int x, int y) {
        visited[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            if (0 <= newX && newX < N && 0 <= newY && newY < N
                    && !visited[newX][newY] && isSame(colors[x][y], colors[newX][newY], true)) {

                dfsForBlind(newX, newY);
            }
        }
    }


    private static boolean isSame(char curr, char comp, boolean isBlind) {
        if (isBlind) {
            return isSameForBlind(curr, comp);
        }
        return curr == comp;
    }

    private static boolean isSameForBlind(char curr, char comp) {
        if (curr == comp) {
            return true;
        }
        if (curr == R) {
            return comp == G;
        }
        if (curr == G) {
            return comp == R;
        }
        return false;
    }

}
