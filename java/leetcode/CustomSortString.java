import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/custom-sort-string/?envType=daily-question&envId=2024-03-11
public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<String, Integer> characterToOrder = new HashMap<>();
        String[] orders = order.split("");
        for (int i = 0; i < orders.length; i++) {
            characterToOrder.put(orders[i], i);
        }
        String[] split = s.split("");
        Arrays.sort(split, (String a, String b) -> {
            Integer aOrder = characterToOrder.get(a);
            Integer bOrder = characterToOrder.get(b);
            if (aOrder != null && bOrder != null) {
                return aOrder - bOrder;
            }
            char aChar = a.charAt(0);
            char bChar = b.charAt(0);
            if (aOrder != null) {
                return aOrder - (int) bChar;
            }
            if (bOrder != null) {
                return (int) aChar - bOrder;
            }
            return (int) aChar - (int) bChar;
        });
        return String.join("", split);
    }
}
