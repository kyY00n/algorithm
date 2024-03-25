package 그리디알고리즘숙제;
import java.util.*;

public class SS1120 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		if(A.length() > B.length())
		{
			B += randomAlphaWord(1);
		}
		else if(A.length() == B.length())
		{
			
		}
		
	}
	
	public static String randomAlphaWord(int wordLength) {

		Random r = new Random();

		StringBuilder sb = new StringBuilder(wordLength);

		

		for(int i = 0; i < wordLength; i++) {

			char tmp = (char) ('a' + r.nextInt('z' - 'a'));

			

			sb.append(tmp);

		}

		

		return sb.toString();

	}

}
