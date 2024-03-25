import java.util.*;

public class bj1 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		int sum = 0;
		int units = 0;
		int tens = 0;
		int count = 0;
		
		input = sc.nextInt(); //26µé¾î¿È
		
		units = input % 10; //6
		tens = input / 10; //2
		
		while(true)
		{
			sum = units + tens; //8
			count++; //1
			
			sum = units*10 + (sum%10);
			if(sum == input) break;
			
			units = sum % 10; 
			tens = sum / 10;
			
		}
		
		System.out.println(count);

	}

}
