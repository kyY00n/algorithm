package programmers;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {

    public static void main(String[] args) {
        캐시_Solution solution = new 캐시_Solution();
        int executionTime = solution.solution(5,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" });
        System.out.println("실행시간:" + executionTime);
    }

}

class 캐시_Solution {

    public int solution(int cacheSize, String[] cities) {

        List<String> cache = new ArrayList();

        int answer = 0;
        for (var city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                answer += 1;
                cache.add(cache.remove(cache.indexOf(city)));
                continue;
            }
            answer += 5;
            cache.add(city);
            if (cache.size() > cacheSize) {
                cache.remove(0);
            }
        }

        return answer;
    }

}
