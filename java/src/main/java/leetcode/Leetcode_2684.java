package leetcode;

public class Leetcode_2684 {
    public int maxMoves(int[][] grid) { // 사악한 3중 for loop
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        for(int c = n-2; c >= 0; c--) {
            for (int r = 0; r < m; r++) {
                int[] drs = { -1, 0, 1 }; // 사실 이 부분을 풀어서 세번 반복하면 3중은 피할 수 있음! 그러나 정석 풀이랑 동일 :D
                for(int dr: drs) {
                    int newR = r + dr;
                    if (0 <= newR && newR < m) {
                        if (grid[r][c] < grid[newR][c + 1]) {
                            ans[r][c] = Math.max(ans[r][c], ans[newR][c+1] + 1);
                        }
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < m; i++) {
            answer = Math.max(answer, ans[i][0]);
        }
        return answer;
    }

}
