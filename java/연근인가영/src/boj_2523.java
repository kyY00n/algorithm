import java.io.*;

public class boj_2523 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			
			int i, j;
			
			for(i = 1; i <= n; i++) {
				for(j = 0; j < i; j++) {
					bw.write("*");
				}
				bw.write("\n");				
			}
			
			for(i=n-1; i>0; i--) {
				for(j = 0; j < i; j++) {
					bw.write("*");
				}
				bw.write("\n");
			}
			
			bw.flush();
			
			br.close();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
