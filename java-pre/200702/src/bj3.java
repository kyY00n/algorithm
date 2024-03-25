import java.util.*;

public class bj3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		String[] name = new String[N];
		
		String[] modifiedName = new String[N];
		
		StringTokenizer st;
		String full = null;
		
		for(int i = 0; i < N; i++)
		{
			full = "";
			name[i] = sc.nextLine();
			st = new StringTokenizer(name[i]);
			st.nextToken();
			while(st.hasMoreTokens())
			{
				full += st.nextToken();
			}
			modifiedName[i] = "god"+full;
		}
		
		for(String a : modifiedName)
		{
			System.out.println(a);
		}
	}

}
