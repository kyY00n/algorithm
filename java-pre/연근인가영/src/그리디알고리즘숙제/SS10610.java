package 그리디알고리즘숙제; //30, 런타임오류
import java.util.*;

public class SS10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N < 30)
		{
			System.out.println(-1);
			return;
		}
		
		byte[] num = new byte[100000];
		
		int i = 0;
		boolean divide = false;
		
		while(true)
		{
			if(N%10 == 0) divide = true;
			num[i] = (byte)(N%10);
			N /= 10;
			if(N==0)break;
			i++;
		}
		
		if(!divide)
		{
			System.out.println(-1);
			return;
		}
		
		int sum = 0;
		for(int j = 0; j < i; j++)
		{
			sum +=num[j];
		}
		
		if(sum%3 != 0)
		{
			System.out.println(-1);
			return;
		}
		
		for(int j = i-1; j > 0; j--)
		{
			for(int k = 0; k < j; k++)
			{
				if(num[k]<num[k+1])
				{
					byte temp = num[k];
					num[k] = num[k+1];
					num[k+1] = temp;
				}
			}
		}
		
		for(int j = 0; j < i; j++)
			System.out.print(num[j]);
		System.out.print(0);
	}

}
