package 그리디알고리즘숙제;

import java.util.*;

public class SS11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] atm = new int[N];
		
		int i = 0, j = 0;
		
		for(i = 0; i < N; i++)
			atm[i] = sc.nextInt();
		
		for(i = N-1; i > 0; i--)
		{
			for(j = 0; j < i; j++)
			{
				if(atm[j] > atm[j+1])
				{
					int temp = atm[j];
					atm[j] = atm[j+1];
					atm[j+1] = temp;
				}
			}
		}
		
		int count = N;
		int sum = 0;
		for(i = 0; i < N; i ++)
		{
			sum += atm[i]*count;
			count--;
		}
		
		System.out.println(sum);
	}
}
