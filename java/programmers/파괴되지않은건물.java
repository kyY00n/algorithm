public class 파괴되지않은건물 {
    public static void main(String[] args) {
        파괴_Solution solution = new 파괴_Solution();
        /**
         * [[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]	[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]
         */
        int answer = solution.solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0,
                0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}});
        System.out.println(answer); // 10
    }
}

class 파괴_Solution {

    public int solution(int[][] board, int[][] skill) {

        int[][] sum = new int[board.length + 1][board[0].length + 1]; // 되돌아가기 위해 r2+1 c2+1

        for(int[] s: skill) {
            int type = s[0]; int r1 = s[1]; int c1 = s[2]; int r2 = s[3]; int c2 = s[4]; int degree = s[5];
            if (type == 1) {
                degree *= -1;
            }
            sum[r1][c1] += degree;
            sum[r1][c2+1] += -1 * degree;
            sum[r2+1][c1] += -1 * degree;
            sum[r2+1][c2+1] += degree;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                sum[i][j] += sum[i][j-1];
            }
        }

        for(int j = 0; j < board[0].length; j++) {
            for(int i = 1; i < board.length; i++) {
                sum[i][j] += sum[i-1][j];
            }
        }

        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if ((board[i][j] + sum[i][j]) > 0) {
                    answer ++;
                }
            }
        }


        return answer;
    }

}
