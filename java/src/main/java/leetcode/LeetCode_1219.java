package leetcode;

public class LeetCode_1219 {
    private int[][] G;
    private boolean[][] visited;
    private int m;
    private int n;
    private int[] dx = new int[]{0, 1, -1, 0};
    private int[] dy = new int[]{1, 0, 0, -1};


    public int getMaximumGold(int[][] grid) {
        G = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int answer = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    answer = Math.max(answer, dfs(i, j, 0));
                }
            }
        }

        return answer;
    }

    private int dfs(int i, int j, int presum) {
        visited[i][j] = true;  // 현재 셀을 방문 처리합니다.
        int currentGold = presum + G[i][j];  // 현재 셀의 금을 추가합니다.

        int maxGold = currentGold;  // 현재까지의 최대 금액을 저장합니다.
        for (int dir = 0; dir < 4; dir++) {  // 모든 가능한 방향을 확인합니다.
            int newX = i + dx[dir];
            int newY = j + dy[dir];

            if (0 <= newX && newX < m && 0 <= newY && newY < n && G[newX][newY] != 0 && !visited[newX][newY]) {
                // 새 위치가 유효하고, 방문하지 않았으며, 금이 있는 셀인 경우
                maxGold = Math.max(maxGold, dfs(newX, newY, currentGold));  // 최대 금액을 갱신합니다.
            }
        }

        visited[i][j] = false;  // 방문 처리를 해제합니다 (백트래킹).
        return maxGold;  // 이 경로에서의 최대 금액을 반환합니다.
    }

}
