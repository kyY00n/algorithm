import java.util.*;

public class ss17365 { //�ذ����^^...
	
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] dict = new String[N];
		for(int i = 0; i < N; i++) {
			dict[i] = sc.next();
		}
		
		String abbr = sc.next();
		int ans = wordCount(dict, abbr)%1000000007;
		
		System.out.println(ans);
		
	}
	
	public static int wordCount(String[] dict, String abbr)
	{		
		for(int i = 0; i < abbr.length(); i++) { //�ܾ� ����
			
			int subCount = 0;
			String str = abbr.substring(0,i);
			
			for(int j = 0; j < dict.length; j++) {
				if(dict[j].length() > i) {
					String cmpString = dict[j].substring(0, i); //������ �ܾ��
					
					if(cmpString.equals(str)) {
						
						if(i+1 == abbr.length()) {
							count++; //���������� ī��Ʈ �ǵ��� ����
							break;
						}
						
						String subString = abbr.substring(i+1, abbr.length()); //���Ҵ��� ����������
						wordCount(dict, subString);
					}
				}
			}
			
			if(subCount == 0) break;
		}
		
		return count;
	}

}
