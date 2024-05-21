package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1300 {

    private static int N;
    private static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int i = binarySearch();
        System.out.println(i);
    }

    private static int binarySearch() {
        // 우리가 탐색하고자 하는 것은 K번째 수. start 와 end 모두 기수이다.
        int start = 1;
        int end = k; // k 번째 수는 k 보다 같거나 작기 때문. (A 배열 특성)
        int answer = 0;
        while(start <= end) {
            int middle = (start + end)/2;
            int lessThanOrEqual = 0;
            for(int i = 1; i <= N; i++) {
                lessThanOrEqual += Math.min(middle/i, N); // 다 더한 다음에
            }
            if (lessThanOrEqual >= k) { // k 번째가 딱 나누어떨어지지 않을 경우를 대비하여 크거나 같은 경우 동일 처리
                answer = middle; // 정답 저장해두기. (k번째가 딱 나오지 않을 수 있음)
                end = middle - 1;
                continue;
            }
            start = middle +1;
        }
        return answer;
    }


}
