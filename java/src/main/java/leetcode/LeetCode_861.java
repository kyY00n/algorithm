package leetcode;

public class LeetCode_861 {
    public int solution(int[][] grid) {
        return new Solution().matrixScore(grid);
    }

}

class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = m * 1 << (n-1); // 무조건 첫번째 컬럼은 1로 만들 수 있다. 따라서 첫 번째 열의 합계를 미리 계산

        for(int j = 1; j < n; j++) { // column마다 반복
            int oneCount = 0;
            for(int i = 0; i < m; i++) {
                if (grid[i][0] == grid[i][j]) {
                    oneCount++;
                }
            }
            answer += Math.max(oneCount, m-oneCount) * 1 << (n - j - 1);
        }

        return answer;
    }
}
