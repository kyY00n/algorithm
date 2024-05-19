package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // ! 이진탐색의 조건은 정렬

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            // binary search
            int target = Integer.parseInt(st.nextToken());
            if (binarySearch(target)) {
                System.out.println("1");
                continue;
            }
            System.out.println("0");
        }
    }

    private static boolean binarySearch(int target) {
        int start = 0, end = arr.length-1;
        int middle = (start + end) / 2;
        while(start <= middle && middle <= end) {
            int compared = arr[middle];
            if (compared == target) {
                return true;
            }
            if (target < compared) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
            middle = (start + end) / 2;
        }
        return false;
    }

}
