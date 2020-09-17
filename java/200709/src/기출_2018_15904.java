import java.util.*;

public class ±‚√‚_2018_15904 {

    static String solution(String s) {
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ucpc[index]) {
                index++;
            }

            if(index == 4) {
                return "I love UCPC";
            }
        }

        return "I hate UCPC";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

}