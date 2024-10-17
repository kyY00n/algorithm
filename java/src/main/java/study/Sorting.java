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

}
