import java.util.*;
class Unit { //���� : ���배�� ��.
	int m, t, y, x; //m:���¹̳� �ѷ�, �̵���/ t: ������ 0�Ǵ�1 
	
	public Unit() {}
	public Unit(int mm, int tt, int aa, int bb) {
		m = mm; t = tt; y = aa; x = bb;
	}
	
	public boolean move(int[][] groundUnit, int u, int y, int x) { //true�� ��ȯ�� ��� ���ο��� ���Ŀ� ������ ��ǥ�� �ٲ��ش�.
		if(groundUnit[y][x] != u)//��ǥ ������ �ٸ� ������ �ִ� ��� && ���� ���� �ƴ�
		{
			
			return false;
		}
		else if() { //��ǥ������ �̵� �Ұ� ���� (���ص��� -1�̰ų� ���¹̳��� ��� �Ҹ��� ���)
			return false;
		}
		else if() { //�̵���(m)-���ص�<0
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
			for(int j = 0; j < W; j++) grounds[i][j] = gDanger[grounds[i][j]-1]; //������ ���ص��� ������.
		}
		
		int numUnit = sc.nextInt();
		
		Unit[] units = new Unit[numUnit];
		int[][] groundUnit = new int[H][W];
		
		for(int i = 0; i < numUnit; i++) {
			units[i] = new Unit(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			groundUnit[units[i].y][units[i].x] = i; //�� unit�� ��ġ�� ������ ����!
		}
		
		int K = sc.nextInt();
		
		int[][] numCommand = new int[K][3]; //������� ���� �迭
		
		for(int i = 0; i < K; i++) {
			numCommand[i][0] = sc.nextInt(); //�̵���ų ������ ��ȣ
			numCommand[i][1] = sc.nextInt(); //y
			numCommand[i][2] = sc.nextInt(); //x
		}
		
		
		
	}

}
