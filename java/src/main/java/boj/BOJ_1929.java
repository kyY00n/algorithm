package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = M; i < N+1; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int number) {
        for(int i = 2; i <= Math.pow(number, 0.5); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        if (number == 1) {
            return false;
        }
        return true;
    }

}
