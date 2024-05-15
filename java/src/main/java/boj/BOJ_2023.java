package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2023 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i < 10; i++) {
            if (isPrime(i)) {
                dfs(i, N);
            }
        }
    }

    private static void dfs(int previous, int N) {
        if ((previous + "").length() == N) {
            System.out.println(previous);
            return;
        }

        int tenTimes = previous * 10;
        for (int i = 0; i < 10; i++) {
            int concatenated = tenTimes + i;
            if (isPrime(concatenated)) {
                dfs(concatenated, N);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.pow(number, 0.5); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
