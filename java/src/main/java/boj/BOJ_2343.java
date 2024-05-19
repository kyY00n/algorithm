package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {

    private static int[] runningTime;
    private static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        runningTime = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            runningTime[i] = Integer.parseInt(st.nextToken());
            sum += runningTime[i];
            max = Math.max(max, runningTime[i]);
        }
        System.out.println(binarySearch(max, sum));
    }

    private static int binarySearch(int start, int end) {
        int result = end;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (count(middle) <= M) {
                result = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return result;
    }

    private static int count(int capacity) {
        int bluRayCount = 1;
        int sum = 0;
        // 강의가 연속적으로 들어가야하므로 순차적으로 더하면서 구하는 수밖에 없음.
        for (int i = 0; i < runningTime.length; i++) {
            if (sum + runningTime[i] > capacity) {
                bluRayCount++;
                sum = 0;
            }
            sum += runningTime[i];
        }
        return bluRayCount;
    }
}
