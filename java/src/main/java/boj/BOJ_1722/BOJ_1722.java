package boj.BOJ_1722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ_1722 {

    private static int N;
    private static long[] factorial;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // calculate and store factorials from 1! to N!
        factorial = new long[N + 1];
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        // determine sub-problem by command
        int command = Integer.parseInt(st.nextToken());
        if (command == 1) { // input k
            Long K = Long.parseLong(st.nextToken());
            printKthSequence(N, K);
            return;
        }

        // input sequence
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        printK(sequence);
    }

    /**
     * @param N: A length of the sequence
     * @param K: given K, finds the kth permutation
     */

    private static void printKthSequence(int N, long K) {
        // Used linked list for traversing from the least value and removing used digit
        List<Integer> numbers = IntStream.range(1, N + 1)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        int[] answer = new int[N];
        int digit = N;
        long kind = K;

        // find inverse sequence
        while (digit > 0) {
            for (int i : numbers) {
                kind -= factorial[digit - 1];
                if (kind <= 0) {
                    kind += factorial[digit - 1];
                    answer[digit - 1] = i;
                    numbers.remove((Integer) i);
                    digit--;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[N - 1 - i] + " ");
        }
    }

    /**
     *
     * @param sequence: given kth sequence
     */
    private static void printK(int[] sequence) {
        int digit = N;
        List<Integer> numbers = IntStream.range(1, N + 1)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        long k = 1; // initialize k to 1 for counting last permutation
        while (digit > 0) {
            for (Integer i : numbers) {
                if (sequence[N - digit] == i) {
                    digit--;
                    numbers.remove(i);
                    break;
                }
                k += factorial[digit - 1];
            }
        }
        System.out.println(k);
    }

}
