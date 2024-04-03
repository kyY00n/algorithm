package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11659
public class GetPrefixSum4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] nums = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }

        int[] prefixSum = new int[N];
        prefixSum[0] = nums[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]) - 1;
            int end = Integer.parseInt(input[1]) - 1;

            System.out.println(prefixSum[end] - prefixSum[start] + nums[start]);
        }

    }

}
