package boj.BOJ_13251;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13251 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 조약돌 가짓수
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 종류별 개수
        int[] stone = new int[M];

        // 전체 돌 개수
        int totalCount = 0;
        for (int i = 0; i < M; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
            totalCount += stone[i];
        }

        // 골라야하는 개수
        int K = Integer.parseInt(br.readLine());

        double answer = 0;
        for (int i = 0; i < M; i++) {
            if (stone[i] < K) {
                continue;
            }
            double probability = 1;
            for(int j = 0; j < K; j++) {
                // k 개를 전부 같은 걸 고를 확률
                probability *= (double) (stone[i] - j) / (totalCount - j);
            }
            answer += probability;
        }
        System.out.println(answer);
    }

}
