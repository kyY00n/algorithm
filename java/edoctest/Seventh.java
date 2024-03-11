import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Seventh {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rl = br.readLine().split(" ");
        int M = Integer.parseInt(rl[0]);
        int N = Integer.parseInt(rl[1]);

        /**
         * 가로: M, 세로: N
         * 6 4
         * 0 0 0 0 0 0
         * 0 0 0 0 0 0
         * 0 0 0 0 0 0
         * 0 0 0 0 0 1
         */
        int[][] tomato = new int[N][M];

        ArrayDeque<List<Integer>> queue = new ArrayDeque();
        for (int i = 0; i < N; i++) {
            String[] readline = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(readline[j]);
                if (tomato[i][j] == 1) {
                    queue.add(List.of(i, j, 0));
                }
            }
        }

        // bfs
        int ans = 0;
        int[] dy = new int[]{1, 0, 0, -1};
        int[] dx = new int[]{0, 1, -1, 0};
        while (!queue.isEmpty()) {
            List<Integer> pos = queue.poll();
            int currY = pos.get(0);
            int currX = pos.get(1);
            int day = pos.get(2);

            for (int i = 0; i < 4; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];
                if ((0 <= nextX && nextX < M) && (0 <= nextY && nextY < N)) { // 좌표가 유효
                    if (tomato[nextY][nextX] == 0) {
                        tomato[nextY][nextX] = 1;
                        if (ans < day + 1) {
                            ans = day + 1;
                        }
                        queue.add(List.of(nextY, nextX, day + 1));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(ans);
    }

}
