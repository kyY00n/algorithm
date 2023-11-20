import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {

    public static void main(String[] args) {
        final var 솔루션 = new 단어변환_solution();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int solution = 솔루션.solution("hit", "cog", words);
        System.out.println(solution);
    }
}



class 단어변환_solution {
    String[] w;
    int[][] adjMat;
    int[] visited;
    int n;

    public int solution(String begin, String target, String[] words) {
        w = words;
        n = words.length;
        adjMat = new int[n][n];
        visited = new int[n];

        int targetIdx = -1;
        for(int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                targetIdx = i;
            }
        }

        if (targetIdx == -1) {
            return 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (hi(w[i], w[j])) {
                    adjMat[i][j] = 1;
                }
            }
        }

        return bfs(begin, targetIdx);
    }

    private boolean hi(String begin, String target) {
        int count = 0;
        char[] b = begin.toCharArray();
        char[] t = target.toCharArray();
        for(int i = 0; i < begin.length(); i++) {
            if (b[i] != t[i]) {
                count++;
            }
        }
        return count == 1;
    }

    private int bfs(String begin, int dest) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(hi(begin, w[i])) {
                q.offer(new int[] {i, 1});
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int idx = curr[0]; int dist = curr[1];
            if (idx == dest) {
                return dist;
            }
            visited[idx] = 1;
            for(int i = 0; i < n; i++) {
                if (adjMat[idx][i] == 1 && visited[i] == 0) {
                    q.offer(new int[]{i, dist + 1});
                }
            }
        }
        return 0;
    }
}
