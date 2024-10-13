package leetcode;

public class Leetcode_66 {
    public int[] plusOne(int[] digits) {
        int toBeChanged = digits.length - 1;
        while (toBeChanged >= 0) {
            if (digits[toBeChanged] != 9) {
                digits[toBeChanged]++;
                return digits;
            }
            digits[toBeChanged] = 0;
            toBeChanged--;
        }
        int[] shifted = new int[digits.length + 1];
        shifted[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            shifted[i+1] = digits[i];
        }
        return shifted;
    }
}
