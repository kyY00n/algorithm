package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1940
public class 주몽 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] materials = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);

        int left = 0;
        int right = N-1;

        int answer = 0;
        while(left < right) {
            int sum = materials[left] + materials[right];
            if (sum < M) {
                left++;
                continue;
            }
            if (sum > M) {
                right--;
                continue;
            }
            answer++;
            left++;
            right--;
        }

        System.out.println(answer);
    }
}
