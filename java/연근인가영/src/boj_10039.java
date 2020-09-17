import java.io.*;
public class boj_10039 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int score = 0;
			int sum = 0;
			for(int i = 0; i < 5; i ++) {
				score = Integer.parseInt(br.readLine());
				if(score<40) sum += 40;
				else sum += score;
			}
			
			bw.write(Integer.toString(sum/5));
			bw.flush();
			
			br.close();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
