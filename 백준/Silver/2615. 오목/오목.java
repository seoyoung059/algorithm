import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] omok;
	
	// 오른쪽 방향으로 확인하도록: 남(1,0), 남동(1,1), 동(0,1), 북동(-1,1)
	static int[] dy = {1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1};
	
	static boolean isValid(int y, int x) {
		return (0<=y)&&(y<19)&&(0<=x)&&(x<19);
	}
	static boolean isWin(int y, int x) {
		int team = omok[y][x];
		int ny, nx;
		direction: for(int i=0; i<4; i++) {
			ny = y-dy[i];
			nx = x-dx[i];
			// 6개 이상 연속 방지
			if(isValid(ny, nx)&&omok[ny][nx]==team)
				continue direction;
			//j = 1~4: 오목인지 확인, j=6: 6개 이상이면 이긴 것이 아님
			for (int j=1; j<6;j++) {
				ny=y+dy[i]*j;
				nx=x+dx[i]*j;
				// 6개 이상 연속 방지
				if(j==5) {
					if(isValid(ny, nx)&&omok[ny][nx]==team) {
						continue direction;
					}
				}
				// 5개 연속으로 있는지 체크
				else{
					if(!isValid(ny,nx)||omok[ny][nx]!=team) {
						continue direction;
					}
				}
			}
			return true;
		}
		return false;
		
	}
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test5.txt"));
		//여기에 코드를 작성하세요.
		omok = new int[19][19];
		
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				omok[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 왼쪽 상단부터 탐색
		for(int y=0; y<19; y++) {
			for(int x=0; x<19; x++) {
				if(omok[y][x]!=0&&isWin(y, x)) {
					System.out.printf("%d\n%d %d",omok[y][x], y+1,x+1);
					return;
				}
			}
		}
		System.out.println(0);
	}
}




