package 그리디알고리즘숙제;
import java.util.Scanner;
public class SS5585 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int change = 1000 - sc.nextInt();
		int count = 0;
		
		while(change > 0)
		{
			if(change >= 500)
			{
				change -= 500;
				count++;
			}
			else if(change >= 100)
			{
				change -= 100;
				count++;
			}
			else if(change >= 50)
			{
				change -= 50;
				count++;
			}
			else if(change >= 10)
			{
				change -= 10;
				count++;
			}
			else if(change >= 5)
			{
				change -= 5;
				count++;
			}
			else
			{
				count += change;
				change = 0;
			}
		}
		
		System.out.println(count);
	}
}
