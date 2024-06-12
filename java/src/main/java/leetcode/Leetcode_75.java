package leetcode;

public class Leetcode_75 {
    public void sortColors(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    private void quicksort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIdx = partition(nums, start, end);
        quicksort(nums, start, pivotIdx - 1);
        quicksort(nums, pivotIdx + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end]; // 피벗 선택
        int i = start - 1; // 피벗보다 작은 요소들의 끝

        for (int j = start; j < end; j++) { // start부터 end-1까지 순회
            if (nums[j] <= pivot) { // 현재 요소가 피벗보다 작거나 같다면
                i++; // i를 증가시키고
                swap(nums, i, j); // i와 j가 가리키는 요소를 교환
            }
        }

        swap(nums, i + 1, end); // i+1과 피벗(끝 요소)을 교환
        return i + 1; // 피벗의 최종 위치 반환
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
