package 그리디알고리즘숙제; //모르겠음
import java.util.*;

public class SS1080 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		if( M<3 || N<3 )
		{
			System.out.println(-1);
			return;
		}
		
		int[][] A = new int[M][N];
		int[][] B = new int[M][N];
		boolean[][] C = new boolean[M][N];
		
		int i = 0, j = 0;
		
		for(i = 0; i < M; i++) {
			String row = sc.next();
			String[] element = row.split("");
			for(j = 0; j < N; j++)
			{
				A[i][j] = Integer.parseInt(element[j]);
			}	
		}
		
		for(i = 0; i < M; i++) {
			String row = sc.next();
			String[] element = row.split("");
			for(j = 0; j < N; j++)
			{
				B[i][j] = Integer.parseInt(element[j]);
				if(A[i][j] == B[i][j]) {
					C[i][j] = true;
				}
				else C[i][j] = false;
			}	
		}
		
		int count = 0;
		
		int k = 0, l = 0;
		
		for(i = 0; i < M-2; i++) {
			for(j = 0; j < N -2; j++) {
				if(!C[i][j]) {
					count += 1;
					for(k = 0; k < 3; k ++) {
						for(l = 0; l < 3; l++) C[i+k][j+l] = !C[i+k][j+l];
					}
				}
			}
			
			if(!C[i][N-2] || !C[i][N-1]) {
				System.out.println(-1);
				return;
			}
		}
		
		for(i = M-2; i < M; i++) {
			for(j = 0; j < N; j++) {
				if(!C[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(count);

	}

}
