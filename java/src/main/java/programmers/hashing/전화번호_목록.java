package programmers.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        Set<String> set = new HashSet<>();
        for(int i = phone_book.length - 1; i >= 0; i--) {
            if (set.contains(phone_book[i])) {
                return false;
            }
            for (int j = 1; j < phone_book[i].length(); j++) {
                set.add(phone_book[i].substring(0, j));
            }
        }

        return true;
    }
}
