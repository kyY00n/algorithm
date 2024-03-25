package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    public static void main(String[] args) {
        완주하지_못한_선수_solution clazz = new 완주하지_못한_선수_solution();
//        String solution = clazz.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
//                new String[]{"josipa", "filipa", "marina", "nikola"});
        String solution = clazz.solution(new String[]{ "mislav", "stanko", "mislav", "ana" }, new String[] {"stanko", "ana", "mislav"});
        System.out.println(solution);
    }
}

/**
 * 100,000
 */

class 완주하지_못한_선수_solution {
    private static Map<String, Integer> nameToCount = new HashMap<>();

    public String solution(String[] participant, String[] completion) {
        for(var p: participant) {
            if (nameToCount.containsKey(p)) {
                nameToCount.put(p, nameToCount.get(p) + 1);
                continue;
            }
            nameToCount.put(p, 1);
        }
        for (var c: completion) {
            int count = nameToCount.get(c);
            nameToCount.put(c, --count);
            if (count == 0) {
                nameToCount.remove(c);
            }
        }
        return (String) nameToCount.keySet().toArray()[0];
    }
}
