package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        // 0부터 가장 높은 곳까지
        int s = 0, e = max;

        int res = 0;
        while(s <= e) {
            int m = (s + e) / 2;
            long sum = 0; // 여기를 int 로 하면 틀릴 수 있다.
            for(int i = 0; i < N; i++) {
                int diff = tree[i] - m;
                if (diff > 0) {
                    sum += diff;
                }
            }
            if (sum >= M) {
                res = m;
                s = m + 1;
                continue;
            }
            e = m - 1;
        }

        System.out.println(res);
    }

}
