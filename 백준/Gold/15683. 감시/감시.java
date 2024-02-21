import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, answer;
	static int[][] arr, cctv;
	static int cctvCnt;
	static int[] dy;
	static int[] dx;
	
	static boolean isValid(int y, int x) {
		return (0<=y)&&(y<n)&&(0<=x)&&(x<m);
	}
	static void count(int[] dir) {
		boolean[][] visited = new boolean[n][m];
		int ny, nx, d; int cnt = 0;
		for(int i=0; i<cctvCnt; i++) {
			if(!visited[cctv[i][1]][cctv[i][2]]) {
				visited[cctv[i][1]][cctv[i][2]] = true;
				cnt++;
			}
			d = dir[i];
			switch(cctv[i][0]) {
			case 1:
				ny = cctv[i][1]+dy[d];
				nx = cctv[i][2]+dx[d];
				while(isValid(ny, nx)&&arr[ny][nx]==0) {
					if(!visited[ny][nx]) cnt++;
					visited[ny][nx]=true;
					ny+=dy[d];
					nx+=dx[d];
				}
				break;
			case 2:
				for(int j=0; j<2; j++) {
					ny = cctv[i][1]+dy[d];
					nx = cctv[i][2]+dx[d];
					while(isValid(ny, nx)&&arr[ny][nx]!=6) {
						if(!visited[ny][nx]) cnt++;
						visited[ny][nx]=true;
						ny+=dy[d];
						nx+=dx[d];
					}
					d = (d+2)%4;
				}
				break;
			case 3:
				for(int j=0; j<2; j++) {
					ny = cctv[i][1]+dy[d];
					nx = cctv[i][2]+dx[d];
					while(isValid(ny, nx)&&arr[ny][nx]!=6) {
						if(!visited[ny][nx]) cnt++;
						visited[ny][nx]=true;
						ny+=dy[d];
						nx+=dx[d];
					}
					d = (d+1)%4;
				}
				break;
			case 4:
				for(int j=0; j<3; j++) {
					ny = cctv[i][1]+dy[d];
					nx = cctv[i][2]+dx[d];
					while(isValid(ny, nx)&&arr[ny][nx]!=6) {
						if(!visited[ny][nx]) cnt++;
						visited[ny][nx]=true;
						ny+=dy[d];
						nx+=dx[d];
					}
					d = (d+1)%4;
				}
				break;
			case 5:
				for(int j=0; j<4; j++) {
					ny = cctv[i][1]+dy[d];
					nx = cctv[i][2]+dx[d];
					while(isValid(ny, nx)&&arr[ny][nx]!=6) {
						if(!visited[ny][nx]) cnt++;
						visited[ny][nx]=true;
						ny+=dy[d];
						nx+=dx[d];
					}
					d = (d+1)%4;
				}
			}
		}
		answer = Math.max(cnt, answer);
	}
	static void sol(int idx, int[] dir) {
		if(idx==cctvCnt) {
			count(dir);
			return;
		}
		int cnt; int ans=0;
		switch(cctv[idx][0]) {
		case 1:
		case 3:
		case 4:
			for(int i=0; i<4; i++) {
				dir[idx]=i;
				sol(idx+1, dir);
			}
			break;
		case 2:
			for(int i=0; i<2; i++) {
				dir[idx]=i;
				sol(idx+1, dir);
			}
			break;
		case 5:
			sol(idx+1, dir);
			break;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		cctv = new int[8][4];
		dy = new int[] {1 ,0, -1, 0};
		dx = new int[] {0, 1, 0, -1};
		int wall = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==6) {
					wall++;
				}
				else if(0<arr[i][j]) {
					cctv[cctvCnt][0] = arr[i][j];
					cctv[cctvCnt][1]=i;
					cctv[cctvCnt][2]=j;
					cctv[cctvCnt++][3] = 0;
				}
			}
		}
		
		int[] dir = new int[cctvCnt];
		sol(0, dir);
		System.out.println(n*m-wall-answer);
	}

}