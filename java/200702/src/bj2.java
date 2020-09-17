import java.util.*;

public class bj2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		int[] num = {n1, n2, n3};
		
		int temp = 0;
		
		for(int i = 2; i > 0; i--)
		{
			for(int j = 0; j < i; j++)
			{
				if(num[j] > num[j+1])
				{
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
		
		System.out.println(num[1]);
	}

}
