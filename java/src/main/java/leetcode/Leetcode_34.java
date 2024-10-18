package leetcode;

public class Leetcode_34 {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int found = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                found = mid;
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        if (found == -1) {
            return new int[] { -1, -1 };
        }

        left = 0;
        right = found - 1;
        int first = found;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {
                    first = mid;
                    break;
                }
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        left = found + 1;
        right = nums.length - 1;
        int last = found;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) { // if middle value is equal to target
                if (mid == nums.length - 1 || nums[mid+1] != target) { // check if it is last
                    last = mid;
                    break;
                }
                // else, we have to move left pointer forward
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }

        return new int[] { first, last };
    }


    public int[] searchRange_improved(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int first = -1;

        // binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // move pointer to the left side
                // first index
                first = mid;
                right = mid - 1;
                continue;
            }
            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        int last = -1;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // update last to mid
                last = mid;
                // move search range to the right
                left = mid + 1;
                continue;
            }
            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        return new int[] { first, last };
    }
}
