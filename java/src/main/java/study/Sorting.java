package study;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class Sorting {

    public static int[] bubblesort(final int[] array) {
        // quadratic time
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) { // 뒤에서 i번째까지는 이미 고정돼있으니 계산할 필요가 없다.
                // i만큼 빼지 않으면 더 많이 연산하게된다.
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionsort(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
        return array;
    }

    public static int[] insertionsort(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i]; // i 번째 값 삽입하기 시작
            for (int j = i - 1; j >= 0; j--) { // i 앞에 정렬된 녀석들 순회하기
                if (array[j] < value) { // 만약 앞에 값이 더 작으면
                    array[j + 1] = value; // 뒤에 붙이기
                    break;
                }
                array[j + 1] = array[j]; // 앞에 값이 작지 않으면 다음 턴으로 넘어가기
                array[j] = value;
            }
        }

        return array;
    }

    public static int[] mergesort(final int[] array) {
        if (array.length == 1) {
            return array;
        }
        int mid = array.length / 2;
        return merge(
                mergesort(copyOfRange(array, 0, mid)),
                mergesort(copyOfRange(array, mid, array.length))
        );
    }

    private static int[] merge(final int[] left, final int[] right) {
        int[] merged = new int[left.length + right.length];
        int l = 0, r = 0;
        int i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                merged[i++] = left[l++];
                continue;
            }
            merged[i++] = right[r++];
        }
        while (l < left.length) {
            merged[i++] = left[l++];
        }
        while (r < right.length) {
            merged[i++] = right[r++];
        }
        return merged;
    }

    public static int[] quicksort(int[] array) {
        quicksort_easy(array, 0, array.length - 1);
        return array;
    }

    private static void quicksort_easy(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = array[end];
        int i = start - 1;
        // i 는 pivot 보다 작은 녀석들의 인덱스를 저장

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++; // pivot 보다 큰 부분으로 i 포인터 전진
                swap(array, i, j); // pivot보다 작은 array[j]와 swap
            }
        }

        // swap pivot with right element
        swap(array, i + 1, end);
        quicksort_easy(array, start, i);
        quicksort_easy(array, i + 2, end);
    }

    private static void quicksort(int[] array, int start, int end) {
        // base case
        if (start >= end) { // simply avoid using invalid range of parameter by testing if start is not less than end
            return;
        }

        // get a pivot
        int pivot = getPivot(array, start, end); // 5

        // divide by pivot
        // 4 6 3 7 1 3 5
        // l         r
        //   l       r
        // 4 3 3 7 1 6 5
        //   l       r
        //     l   r
        //       l r
        // 4 3 3 1 7 6 5
        //       l r
        //       r l

        int left = start;
        int right = end - 1;

        while (left <= right) { // after closing the while loop, we get right < left and
            if (array[left] < pivot) {
                left++;
                continue;
            }
            if (array[right] > pivot) {
                right--;
                continue;
            }
            swap(array, left, right);
        }

        swap(array, left, end);

        // 4 3 3 1 5 6 7
        //         l
        quicksort(array, start, left - 1);
        quicksort(array, left + 1, end);
    }

    private static int getPivot(final int[] array, int start, int end) {
        int middle = start + (end - start) / 2;
        int pivot = array[middle];
        array[middle] = array[end];
        array[end] = pivot;
        return pivot;
    }

    private static void swap(final int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static int quickSelect(final int[] array, int k) {
        return quickSelect(array, 0, array.length - 1, k - 1);

    }

    private static int quickSelect(final int[] array, int start, int end, int k) {
        if (start == end) {
            return array[start];
        }
        int pivot = getPivot(array, start, end);
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (array[left] < pivot) {
                left++;
                continue;
            }
            if (array[right] > pivot) {
                right--;
                continue;
            }
            swap(array, left, right);
        }
        swap(array, left, end);

        // Only this part is different from quicksort
        if (left == k) {
            return array[left];
        }
        // if the left is smaller than k, we have to find the kth element on the right side
        if (left < k) {
            return quickSelect(array, left + 1, end, k);
        }
        // if the left is bigger than k, we have to find the kth element on the left side
        return quickSelect(array, start, left - 1, k);
    }
}
