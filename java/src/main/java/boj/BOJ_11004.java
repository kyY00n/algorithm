package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11004
public class BOJ_11004 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickK(arr, K, 0, arr.length-1);
        System.out.println(arr[K-1]);
    }

    private static void quickK(int[] arr, int K, int start, int end) {
        if (start >= end) return; // Correct the termination condition

        int pivotIdx = (start + end) / 2;
        int pivot = arr[pivotIdx];
        swap(arr, start, pivotIdx);

        int i = start + 1, j = end;
        while (i <= j) { // 교차하지 않는 동안 계속 실행
            while (i <= end && arr[i] < pivot) i++; // i의 범위를 계속 체크해줘야함.
            while (j > start && arr[j] > pivot) j--;
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        swap(arr, start, j); // Adjust to swap at j

        if (j == K - 1) return; // Found the K-th element
        else if (j < K - 1) quickK(arr, K, j + 1, end);
        else quickK(arr, K, start, j - 1);
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
