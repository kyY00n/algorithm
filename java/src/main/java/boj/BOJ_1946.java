package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st;
            int[] scoreRank = new int[N];
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int 서류_순위 = Integer.parseInt(st.nextToken());
                int 면접_순위 = Integer.parseInt(st.nextToken());
                scoreRank[서류_순위 - 1] = 면접_순위;
            }

            int answer = N, rank = N;
            for(int j = 0; j < N; j++) {
                if (scoreRank[j] > rank) {
                    answer--;
                    continue;
                }
                rank = scoreRank[j];
            }

            System.out.println(answer);
        }
    }
}
