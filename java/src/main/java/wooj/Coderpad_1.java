package wooj;

public class Coderpad_1 {

    /**
     * Suppose we are given a string “aaabbbbbccccdaa”, then we to print “a3b5c4d1a2”.
     *
     * @param str
     * @return compressed string
     */
    public String solve(final String str) {
        StringBuilder sb = new StringBuilder();
        for (int start = 0; start < str.length(); ) {
            char first = str.charAt(start); // the character is start-th character in the str.
            int end;
            for (end = start + 1; end < str.length(); end++) {
                char next = str.charAt(end);
                if (next != first) {
                    break;
                }
            }
            int count = end - start;
            sb.append((first + "") + count);

            start = end;
        }

        return sb.toString();
    }

    public String solve_improved(final String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();

        for (int start = 0; start < n; ) {
            char first = str.charAt(start);
            int end = start + 1;

            // end가 범위를 넘지 않는 동안, first와 같은 문자가 반복되는지 확인
            while (end < n && str.charAt(end) == first) {
                end++;
            }

            // 문자와 반복된 횟수를 StringBuilder에 추가
            sb.append(first).append(end - start);

            // 다음 문자로 이동
            start = end;
        }

        return sb.toString();
    }

}
