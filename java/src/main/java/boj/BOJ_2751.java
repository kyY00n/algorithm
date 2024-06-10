package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2751 {

    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, N - 1);

        StringBuilder sb = new StringBuilder(); // StringBuilder를 사용하지 않았을 경우 시간초과가 났다.
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    private static void mergeSort(int start, int end) {
        if (start >= end) {
            return; // 기저 조건
        }

        int middle = (start + end) / 2;
        mergeSort(start, middle);
        mergeSort(middle + 1, end);
        merge(start, middle, end);
    }

    private static void merge(int start, int middle, int end) { // 합병하는 부분을 함수로 추출
        int[] temp = new int[end - start + 1];

        int p1 = start, p2 = middle + 1, k = 0;
        while (p1 <= middle && p2 <= end) {
            if (arr[p1] <= arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }

        while (p1 <= middle) {
            temp[k++] = arr[p1++];
        }

        while (p2 <= end) {
            temp[k++] = arr[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }
}
