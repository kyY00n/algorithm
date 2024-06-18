package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int start = 1;  // 최소 거리
        int end = home[N - 1] - home[0];  // 최대 거리
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;  // 중간 거리
            int count = 1;  // 첫 집에 하나 설치
            int prev = home[0];

            for (int i = 1; i < N; i++) {
                if (home[i] - prev >= mid) {
                    count++;
                    prev = home[i];
                }
            }

            if (count >= C) {  // 공유기를 C개 이상 설치할 수 있는 경우
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
