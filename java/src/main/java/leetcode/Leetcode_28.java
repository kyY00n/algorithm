package leetcode;

public class Leetcode_28 {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }

        return -1;
    }

    public int improvedStrStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }

    public int moreImprovedStrStr(String haystack, String needle) {
        // Actually, we don't need to use haystack.contains
        return haystack.indexOf(needle);
    }

}
