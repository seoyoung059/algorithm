import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int h, w;
	static boolean isValid(int y, int x) {
		return (0<=y)&&(y<h)&&(0<=x)&&(x<w);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int  n, ny, nx; String input; int tmp;
		char[][] map; int[] tank = new int[3];
		int[][] shoot =  {{-1, 0}, {1, 0}, {0,-1}, {0,1}}; 
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			
			for(int i=0; i<h; i++) {
				input = br.readLine();
				for(int j=0; j<w; j++) {
					map[i][j] = input.charAt(j);
					tmp = "^v<>".indexOf(map[i][j]);
					if(tmp>=0) {
						tank[0]=i; tank[1]=j; tank[2] = tmp;
						map[i][j] = '.';
					}
				}
			}
			
			n = Integer.parseInt(br.readLine());
			input = br.readLine();
			
			for(int i=0; i<n; i++) {
				switch(input.charAt(i)) {
				case 'U': // U
					tank[2] = 0;
					if(isValid(tank[0]-1, tank[1])&&map[tank[0]-1][tank[1]]=='.') {
						tank[0]--;
					}
					break;
				case 'D': // D
					tank[2] = 1;
					if(isValid(tank[0]+1, tank[1])&&map[tank[0]+1][tank[1]]=='.') {
						tank[0]++;
					}
					break;
				case 'L': // L
					tank[2] = 2;
					if(isValid(tank[0], tank[1]-1)&&map[tank[0]][tank[1]-1]=='.') {
						tank[1]--;
					}
					break;
				case 'R': // R
					tank[2] = 3;
					if(isValid(tank[0], tank[1]+1)&&map[tank[0]][tank[1]+1]=='.') {
						tank[1]++;
					}
					break;
				case 'S': // S
					ny = tank[0]+shoot[tank[2]][0]; nx = tank[1]+shoot[tank[2]][1];
					while(isValid(ny, nx)) {
						if(map[ny][nx]=='*') {
							map[ny][nx]='.';
							break;
						}
						else if(map[ny][nx]=='#') {
							break;
						}
						ny+=shoot[tank[2]][0];
						nx+=shoot[tank[2]][1];
					}
					break;
				}
				
			}
			map[tank[0]][tank[1]] = "^v<>".charAt(tank[2]);
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);

	}

}