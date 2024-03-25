package edoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class 기념일1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2015년 9월 17일 부터 사귐

    }

    private static boolean 윤년여부(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}
