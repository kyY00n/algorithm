package programmers;

public class 네트워크 {

    public static void main(String[] args) {
        final var 솔루션 = new 네트워크_solution();
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int solution = 솔루션.solution(3, computers);
        System.out.println(solution);
    }
}

class 네트워크_solution {
    private int[] visited;
    private int[][] c;

    public int solution(int n, int[][] computers) {
        visited = new int[n];
        c = computers;

        int answer = 0;
        for(int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for(int j = 0; j < c.length; j ++) {
            if (c[i][j] == 1 && visited[j] == 0) {
                dfs(j);
            }
        }
    }
}
