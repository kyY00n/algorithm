package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.LongStream;

public class BOJ_1456 {

    public static final double MAX_INPUT = Math.pow(10, 14);
    private static Set<Long> almostPrimes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        saveAlmostPrime();

        long answer = LongStream.range(A, B + 1)
                .filter(num -> isAlmostPrime(num))
                .count();

        System.out.println(answer);
    }

    private static void saveAlmostPrime() {
        almostPrimes = new HashSet<>();

        for(long i = 2; i <= Math.pow(10, 7); i++) {
            if (isPrime(i)) {
                long almostPrime = i;
                while(almostPrime < MAX_INPUT) {
                    almostPrimes.add(almostPrime);
                    almostPrime *= i;
                }
            }
        }
    }

    private static boolean isPrime(final long number) {
        if (number == 1) {
            return false;
        }
        for(long i = 2; i <= Math.pow(number, 0.5); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAlmostPrime(long number) {
        return almostPrimes.contains(number);
    }

}
