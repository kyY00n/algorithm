package leetcode._1456;

import java.util.Set;

public class Leetcode_1456_improved {

    // Using an array instead of a set for better performance
    private int[] value = new int[128];

    public int maxVowels(String s, int k) {
        // Initialize the array to mark vowels
        value['a'] = 1;
        value['e'] = 1;
        value['i'] = 1;
        value['o'] = 1;
        value['u'] = 1;

        // Count the number of vowels in the first k characters
        int temp = 0;
        for (int i = 0; i < k; i++) {
            if (value[s.charAt(i)] == 1) {
                temp++;
            }
        }

        // Initialize max with the count of vowels in the first k characters
        int max = temp;

        // Slide the window of size k through the string
        for (int i = k; i < s.length(); i++) {
            temp -= value[s.charAt(i - k)]; // Remove the character going out of the window
            temp += value[s.charAt(i)]; // Add the new character coming into the window
            max = Math.max(max, temp);
        }

        return max;
    }

}
