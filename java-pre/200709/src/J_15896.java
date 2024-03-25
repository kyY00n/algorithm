import java.util.*;

public class J_15896 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		int i = 0;
		for(i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for(i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		
		int j = 0;
		int sum = 0;
		
		for(i = 0; i < N; i ++) {
			for(j = 0; j < N; j++) {
				sum += (A[i] & B[j]);
			}
		}
	
		int result1 = sum % 1999;
		
		int result2 = A[0]+B[0];
		
		for(i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				if( i+j == 0 ) continue;
				else
				{
					result2 &= (A[i]+B[j]);
				}
			}
		}
		
		System.out.print(result1+" ");
		System.out.println(result2);
	}

}
