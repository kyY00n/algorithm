package programmers.hashing;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completedName = new HashMap<>();
        for(String name: completion) {
            completedName.put(name, completedName.getOrDefault(name, 0) + 1);
        }
        for(String name: participant) {
            if (!completedName.containsKey(name) || completedName.get(name) < 1) {
                return name;
            }
            completedName.put(name, completedName.get(name) - 1);
        }
        throw new RuntimeException();
    }

}
