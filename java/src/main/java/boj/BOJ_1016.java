package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1016 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] isNotSquareFree = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = min / square;
            if (min % square != 0) {
                start++;
            }
            start *= square;

            for (long j = start; j <= max; j += square) {
                isNotSquareFree[(int) (j - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < isNotSquareFree.length; i++) {
            if (!isNotSquareFree[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
