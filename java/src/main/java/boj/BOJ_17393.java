package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17393 {

    private static int N;
    private static long[] A;
    private static long[] B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        B = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(binarySearch(i) + " ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int idx) {
        int s = 0, e = B.length - 1;
        int res = 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (A[idx] >= B[m]) {
                res = m - idx;
                s = m + 1;
                continue;
            }
            e = m - 1;
        }
        return res;
    }

}
