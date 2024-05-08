package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quicksort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(arr[K-1]);
        br.close();
    }

    private static void quickSort(int[] arr, int left, int right) {
        int start = left, end = right;
        if (right <= left) {
            return;
        }
        int pivotIdx = (left + right) / 2;
        int pivot = arr[pivotIdx];
        arr[pivotIdx] = arr[right];
        arr[right--] = pivot;

        while (left < right) {
            if (arr[left] < pivot) {
                left++;
            }
            else if (arr[right] > pivot) {
                right--;
            }
            if (arr[left] > arr[right]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int swapPos = arr[right] < pivot ? right + 1 : right;
        int temp = arr[swapPos];
        arr[swapPos] = pivot;
        arr[end] = temp;

        quickSort(arr, start, swapPos - 1);
        quickSort(arr, swapPos + 1, end);
    }
}
