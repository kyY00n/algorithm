package edoctest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fifth {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i< N;i++) {
            P[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(P);
        int[] answer = new int[N];
        answer[0] = P[0];
        int sum = answer[0];
        for(int i = 1; i < N; i++) {
            answer[i] = answer[i-1] + P[i];
            sum += answer[i];
        }
        System.out.println(sum);
    }
}
