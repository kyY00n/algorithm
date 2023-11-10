import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {
    private static String[] order = {"RT", "CF", "JM", "AN"};
    private static Map<String, Integer> scores = new HashMap<>() {{
        put("RT", 0);
        put("CF", 0);
        put("JM", 0);
        put("AN", 0);
    }};

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String solution = solution(survey, choices);
        System.out.println(solution);
    }

    public static String solution(String[] survey, int[] choices) {
        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            Integer preScore = scores.get(s);
            int choice = choices[i] - 4;
            if (preScore == null) {
                StringBuffer sb = new StringBuffer(s);
                s = sb.reverse().toString();
                preScore = scores.get(s);
                choice *= -1;
            }
            scores.put(s, preScore + choice);
        }
        StringBuilder sb = new StringBuilder();
        for (final var indicator: order) {
            Integer score = scores.get(indicator);
            if (score < 0) {
                sb.append(indicator.charAt(0));
                continue;
            }
            if (score > 0){
                sb.append(indicator.charAt(1));
                continue;
            }
            sb.append(indicator.charAt(0));
        }
        return sb.toString();
    }
}
