package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17213 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // N가지의 과일을 훔치는데, M개를 훔친다.
        // 모든 종류 과일을 1개씩은 훔쳐야함.
        // M을 5 그룹으로 나누면 되는건가

        // 일단 1씩 다 나눠주면, M - N 개를 분배하기만 하면된다.

        // N가지 과일 중 M개를 중복 허용하여 훔치는 경우의 수
        int divided = M - N; // N개의 과일을 각 1개씩 가져가고 남은 M - N개를 분배

        // DP 테이블 생성
        int[][] C = new int[N + 1][divided + 1];

        // 초기 조건: C[i][0] = 1 (i개의 과일 종류에서 0개의 과일을 고르는 방법은 1가지)
        for (int i = 0; i <= N; i++) {
            C[i][0] = 1;
        }

        // DP 점화식을 이용한 중복 조합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= divided; j++) {
                // i번째 과일을 j개의 남은 과일 중 선택하는 경우 계산
                C[i][j] = C[i-1][j] + C[i][j-1];
            }
        }

        // 정답 출력: N개의 과일 종류로 divided 개의 남은 과일을 분배하는 경우의 수
        System.out.println(C[N][divided]);
    }

}
