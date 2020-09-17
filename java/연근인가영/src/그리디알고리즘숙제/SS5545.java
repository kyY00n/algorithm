package �׸���˰������; //�ְ��� ����
import java.util.*;

public class SS5545 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //���� ����
		int A = sc.nextInt(); //���� ����
		int B = sc.nextInt(); //���� ����
		int C = sc.nextInt(); //������ ����
		
		int[] D = new int[N]; //���� ����
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
