package leetcode.leetcode69;

public class Leetcode_69 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int start = 1;
        int end = x;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid*mid;
            if (square > x) {
                end = mid - 1;
            } else if (square < x) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return end;
    }
}
