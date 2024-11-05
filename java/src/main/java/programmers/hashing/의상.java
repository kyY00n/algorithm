package programmers.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 의상 {
    public int solution(String[][] clothes) {
        Map<String, Set<String>> categoryToClothes = new HashMap<>();
        for(String[] clothe: clothes) {
            if (categoryToClothes.containsKey(clothe[1])) {
                categoryToClothes.get(clothe[1]).add(clothe[0]);
                continue;
            }
            Set<String> clothesInCategory = new HashSet<>();
            clothesInCategory.add(clothe[0]);
            categoryToClothes.put(clothe[1], clothesInCategory);
        }
        int answer = 1;
        for(String category: categoryToClothes.keySet()) {
            answer *= (categoryToClothes.get(category).size() + 1);
        }
        return answer - 1;
    }

}
