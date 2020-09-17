import java.io.*;

public class boj_5543 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int Bugger = 0, minBugger = 2000;
			for(int i = 0; i < 3; i++) {
				Bugger = Integer.parseInt(br.readLine());
				if(Bugger < minBugger) minBugger = Bugger;
			}
			
			int bev = 0, minBev = 2000;
			for(int i = 0; i < 2; i++) {
				bev = Integer.parseInt(br.readLine());
				if(bev < minBev) minBev = bev;
			}
			
			bw.write(Integer.toString(minBugger+minBev-50));
			bw.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
