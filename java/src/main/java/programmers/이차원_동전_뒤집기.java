package programmers;

public class 이차원_동전_뒤집기 {

    public static void main(String[] args) {
        final var 솔루션 = new 이차원_동전_뒤집기_solution();
        int[][] beginning = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int[][] target = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        int solution = 솔루션.solution(beginning, target);
        System.out.println(solution);
    }
}


class 이차원_동전_뒤집기_solution {

    private int w;
    private int h;

    private int[][] b;
    private int[][] t;

    public int solution(int[][] beginning, int[][] target) {
        this.b = beginning;
        this.t = target;

        int answer = Integer.MAX_VALUE;
        h = beginning.length;
        w = beginning[0].length;

        int total = 1 << (h + w);
        for(int caseNum = 0; caseNum < total; caseNum++) {
            int count = reverse(caseNum);
            answer = Math.min(answer, count);
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    private int reverse(int reverser) {
        int count = 0;

        int[][] copyOfB = new int[h][w];

        for (int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                copyOfB[i][j] = b[i][j];
            }
        }

        for (int i = 0; (1 << i) <= reverser; i++) {
            if((reverser & (1 << i)) != 0) {
                count++;
                reverseOne(copyOfB, i);
            }
        }

        if (equal(copyOfB)) {
            return count;
        }

        return Integer.MAX_VALUE;
    }

    private void reverseOne(int[][] copyOfB, int num) {
        if (num < h) {
            reverseRow(copyOfB, num);
            return;
        }
        reverseColumn(copyOfB, num - h);
    }

    private void reverseRow(int[][] copyOfB, int rowNum) {
        for (int j = 0; j < w; j++) {
            copyOfB[rowNum][j] ^= 1;
        }
    }

    private void reverseColumn(int[][] copyOfB, int columnNum) {
        for (int i = 0; i < h; i++) {
            copyOfB[i][columnNum] ^= 1;
        }
    }

    private boolean equal(int[][] copyOfB) {
        for (int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if (copyOfB[i][j] != t[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
