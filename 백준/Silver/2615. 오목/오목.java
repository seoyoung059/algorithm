import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] omok;
	static int[] dy = {1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1};
	
	static boolean isValid(int y, int x) {
		return (0<=y)&&(y<19)&&(0<=x)&&(x<19);
	}
	
	static void solution() {
		int ny, nx, team;
		for(int y=0; y<19; y++) {
			for(int x=0;x<19;x++) {
				team = omok[y][x];
				if(team!=0) {
					direction: for (int i=0; i<4;i++) {
						ny = y-dy[i]; nx = x-dx[i];
						if(isValid(ny, nx)&& omok[ny][nx]==team)
							continue direction;
						for(int k=1; k<6; k++) {
							ny = y+dy[i]*k;
							nx = x+dx[i]*k;
							if(k<5&&(!isValid(ny, nx) || omok[ny][nx]!=team))
								continue direction;
							else if(k==5 && isValid(ny,nx) && omok[ny][nx]==team)
								continue direction;
						}
						sb.append(team);
						sb.append("\n");
						sb.append(y+1);
						sb.append(" ");
						sb.append(x+1);
						return;
					}
				}
			}
		}
		sb.append(0);
	}
	
	public static void main(String[] args) throws IOException {
		omok = new int[19][19];
		
		for(int y=0; y<19; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<19;x++) {
				omok[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution();
		System.out.print(sb.toString());
	}

}