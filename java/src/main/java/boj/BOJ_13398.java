package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13398 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] L = new int[N];
        L[0] = seq[0];
        int answer = L[0];
        for(int i = 1; i < N; i++) {
            L[i] = Math.max(L[i-1] + seq[i], seq[i]);
            answer = Math.max(answer, L[i]);
        }

        int[] R = new int[N];
        R[N-1] = seq[N-1];
        for(int i = N-2; i >= 0; i--) {
            R[i] = Math.max(R[i+1] + seq[i], seq[i]);
        }

        for(int i = 1; i < N-1; i++) {
            int temp = L[i-1] + R[i+1];
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);

    }

}

