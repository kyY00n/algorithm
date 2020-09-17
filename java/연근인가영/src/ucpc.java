import java.util.*;
class Unit { //진영 : 군대같은 것.
	int m, t, y, x; //m:스태미나 총량, 이동력/ t: 세력은 0또는1 
	
	public Unit() {}
	public Unit(int mm, int tt, int aa, int bb) {
		m = mm; t = tt; y = aa; x = bb;
	}
	
	public boolean move(int[][] groundUnit, int u, int y, int x) { //true를 반환할 경우 메인에서 이후에 유닛의 좌표를 바꿔준다.
		if(groundUnit[y][x] != u)//목표 지점에 다른 유닛이 있는 경우 && 교전 중이 아님
		{
			
			return false;
		}
		else if() { //목표지점이 이동 불가 지형 (험준도가 -1이거나 스태미나를 모두 소모한 경우)
			return false;
		}
		else if() { //이동력(m)-험준도<0
			return false;
		}
	}
}
public class ucpc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		int[][] grounds = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) grounds[i][j] = sc.nextInt();
		}
		
		int[] gDanger = new int[N];
		for(int i = 0; i < N; i++) {
			gDanger[i] = sc.nextInt();
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) grounds[i][j] = gDanger[grounds[i][j]-1]; //지형의 험준도로 저장함.
		}
		
		int numUnit = sc.nextInt();
		
		Unit[] units = new Unit[numUnit];
		int[][] groundUnit = new int[H][W];
		
		for(int i = 0; i < numUnit; i++) {
			units[i] = new Unit(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			groundUnit[units[i].y][units[i].x] = i; //각 unit의 위치를 저장한 지도!
		}
		
		int K = sc.nextInt();
		
		int[][] numCommand = new int[K][3]; //약진명령 저장 배열
		
		for(int i = 0; i < K; i++) {
			numCommand[i][0] = sc.nextInt(); //이동시킬 유닛의 번호
			numCommand[i][1] = sc.nextInt(); //y
			numCommand[i][2] = sc.nextInt(); //x
		}
		
		
		
	}

}
