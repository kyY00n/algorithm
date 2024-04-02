package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> flipped = new HashMap<>();
        HashSet<Character> occurence = new HashSet<>();

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (flipped.containsKey(sArr[i])) {
                if (flipped.get(sArr[i]) != tArr[i]) {
                    return false;
                }
                continue;
            }

            if (occurence.contains(tArr[i])) {
                return false;
            }
            flipped.put(sArr[i], tArr[i]);
            occurence.add(tArr[i]);
        }

        return true;
    }

    /**
     * 알파벳으로 한정되어있는 줄 알고, 아스키코드 연산을 통해 풀려고 했으나, 문제 조건에 `s and t consist of any valid ascii character.`가 있었음.
     */

    // public boolean isIsomorphic(String s, String t) {
    //     char[] flipped = new char[26];
    //     boolean[] occurence = new boolean[26];

    //     Arrays.fill(flipped, '-');

    //     char[] sArr = s.toCharArray();
    //     char[] tArr = t.toCharArray();

    //     for(int i = 0; i < s.length(); i++) {
    //         int index = (int)(sArr[i] - 'a'); // 이번 알파벳 sArr
    //         if (flipped[index] != '-') { // 이미 뒤집힌 적 있는 경우
    //             if (flipped[index] != tArr[i]) {
    //                 return false;
    //             }
    //             continue;
    //         }
    //         // sArr 을 tArr로 갱신해야함
    //         int target = (int)(tArr[i] - 'a');
    //         if (occurence[target]) { // tArr에서 이미 한번 바뀐 애가 나오는 경우
    //             return false;
    //         }
    //         flipped[index] = tArr[i];
    //         occurence[target] = true;
    //     }

    //     return true;
    // }
}
