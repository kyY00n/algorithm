import java.util.*;
public class ss1120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		char[] charA = A.toCharArray();
		char[] charB = B.toCharArray();
		
		int diff = charB.length - charA.length;
		
		int min = charA.length;
		
		int[] count = new int[diff+1];
		
		for(int i = 0; i < diff+1; i++) {
			
			for(int j = i; j < i+charA.length-1; j++) {
				if (charA[j] != charB[j]) count[i]++;
			}
			
			if(count[i] < min) min = count[i];
		}
		
		System.out.println(min);
	}

}
