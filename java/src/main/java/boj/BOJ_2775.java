package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2775 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] people = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                people[0][i] = i;
            }
            for(int i = 0; i <= k; i++) {
                people[i][1] = 1;
            }

            for (int i = 1; i <= k; i++) {
                for(int j = 2; j <= n; j++) {
                    people[i][j] = people[i][j-1] + people[i-1][j];
                }
            }
            System.out.println(people[k][n]);
        }
    }

}
