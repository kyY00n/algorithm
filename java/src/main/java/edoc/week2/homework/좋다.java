package edoc.week2.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1253
public class 좋다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] seq = new long[N];
        for(int i = 0; i < N; i++) {
            seq[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(seq);

        int answer = 0;
        for(int i = 1; i < N; i++) {
            long K = seq[i];
            int left = 0;
            int right = i-1;
            while(left < right) {
                long sum = seq[left] + seq[right];
                if (sum < K) {
                    left++;
                    continue;
                }
                if (sum > K) {
                    right--;
                    continue;
                }
                if (i == left) {
                    left++;
                    continue;
                }
                if (i == right) {
                    right--;
                    continue;
                }
                answer++;
                break;
            }
        }
        System.out.println(answer);

    }

}
