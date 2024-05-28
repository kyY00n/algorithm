package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1744 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 0;
        int idx = 0;
        while (idx < arr.length && arr[idx] <= 0) {
            if (idx + 1 < arr.length && arr[idx+1] <= 0) {
                answer += arr[idx] * arr[++idx];
                idx++;
                continue;
            }
            answer += arr[idx++];
        }

        while(idx < arr.length && arr[idx] == 1) {
            answer += 1;
            idx++;
        }

        int reverseIdx = arr.length - 1;
        while(reverseIdx >= idx) {
            if (reverseIdx == idx) {
                answer += arr[reverseIdx];
                break;
            }
            answer += arr[reverseIdx] * arr[--reverseIdx];
            reverseIdx--;
        }

        System.out.println(answer);
    }


}
