package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 개인정보_수집_유효기간 {

    public static void main(String[] args) {

//        int[] solution = solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A",
//                "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        int[] solution = solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});
//        int[] solution = solution("2020.01.01", new String[]{"Z 3", "D 24"}, new String[]{"2019.08.02 D"});
        for(var s: solution) {
            System.out.printf("%d ",s);
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> alphaToTerm = new HashMap<>();
        for(final var term: terms) {
            String[] alphaAndTerm = term.split(" ");
            alphaToTerm.put(alphaAndTerm[0], Integer.parseInt(alphaAndTerm[1]));
        }
        List<Integer> answers = new ArrayList<>();

        MyDate todayDate = new MyDate(today);
        for(int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] split = privacy.split(" ");
            MyDate privacyDate = new MyDate(split[0], alphaToTerm.get(split[1]));

            if (!todayDate.isBeforeThan(privacyDate)) {
                answers.add(i+1);
            }
        }

        return answers.stream().mapToInt(i -> i).toArray();
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(String date) {
        String[] split = date.split("\\.");
        this.year = Integer.parseInt(split[0]);
        this.month = Integer.parseInt(split[1]);
        this.day = Integer.parseInt(split[2]);
    }

    public MyDate(String date, int afterMonth) {
        String[] split = date.split("\\.");
        int month = Integer.parseInt(split[1]) + afterMonth;
        int year = Integer.parseInt(split[0]);
        year += (month - 1) / 12; // 새로운 연도 계산
        month = (month - 1) % 12 + 1; // 새로운 월 계산
        int day = Integer.parseInt(split[2]);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    boolean isBeforeThan(MyDate otherDate) {
        if (this.year == otherDate.year) {
            if (this.month == otherDate.month) {
                return this.day < otherDate.day;
            }
            return this.month < otherDate.month;
        }
        return this.year < otherDate.year;
    }

    @Override
    public String toString() {
        return "" + year + "." + month + "." + day;
    }
}
