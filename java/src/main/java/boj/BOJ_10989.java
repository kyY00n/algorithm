package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BOJ_10989 {

    private static int[] arr;
    private static int[] output;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        radixSort();

        StringBuilder sb = new StringBuilder();
        for (int e : arr) {
            sb.append(e + "\n");
        }
        System.out.println(sb);

    }

    private static void radixSort() {
        int divisor = 1;
        output = new int[arr.length];
        int[] count;

        for (int d = 0; d < 5; d++) {
            count = new int[10];

            // Counting occurrences of digits
            for (int number : arr) {
                int digit = (number / divisor) % 10;
                count[digit]++;
            }

            // Transform count into prefix sums
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // Build the output array
            for (int i = arr.length - 1; i >= 0; i--) {
                int number = arr[i];
                int digit = (number / divisor) % 10;
                output[--count[digit]] = number;
            }

            // Copy the output array to arr
            System.arraycopy(output, 0, arr, 0, arr.length);

            // Move to the next significant digit
            divisor *= 10;
        }
    }

    private static void radixSort_memory() {
        List<Queue<Integer>> queues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queues.add(new ArrayDeque<>());
        }
        int divisor = 1;
        for (int digit = 0; digit < 5; digit++) {
            // 현재 자리수에 맞춰 배열을 큐에 저장
            for (int i = 0; i < arr.length; i++) {
                int idx = (arr[i] / divisor) % 10;
                Queue<Integer> queue = queues.get(idx);
                queue.offer(arr[i]);
            }
            // 큐에서 배열로 값을 되돌림
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                Queue<Integer> queue = queues.get(i);
                while (!queue.isEmpty()) {
                    arr[idx] = queue.poll();
                    idx++;
                }
            }
            // 다음 자리수를 위해 divisor를 10으로 증가
            divisor *= 10;
        }
    }

    // 큐를 사용하면 메모리 초과가 난다.
}
