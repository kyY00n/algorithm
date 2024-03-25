package 그리디알고리즘숙제; //최고의 피자
import java.util.*;

public class SS5545 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //토핑 개수
		int A = sc.nextInt(); //도우 가격
		int B = sc.nextInt(); //토핑 가격
		int C = sc.nextInt(); //도우의 열량
		
		int[] D = new int[N]; //토핑 가격
		for(int i = 0; i < N; i++)
			D[i] = sc.nextInt();
		
		Arrays.sort(D);
		
		int price = A;
		
		int maxCal = C/A;
		
		int newCal = 0;
		int totalCal = C;
		
		for(int j = N-1; j > 0; j--)
		{
			totalCal += D[j];
			price += B;
			newCal = totalCal/price;
			
			if(maxCal > newCal) break;
			maxCal = newCal;
		}
		
		System.out.println(maxCal);
			
	}
}
