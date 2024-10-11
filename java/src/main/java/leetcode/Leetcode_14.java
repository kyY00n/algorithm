package leetcode;

public class Leetcode_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String element = strs[i];
            if (element.startsWith(prefix)) {
                continue;
            }
            while (prefix.length() > 0 && !element.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }
}
