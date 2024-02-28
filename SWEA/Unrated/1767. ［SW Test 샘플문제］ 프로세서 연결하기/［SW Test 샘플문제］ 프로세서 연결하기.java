import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	static BufferedReader br;
	static int connectedMax, answer, n;
	static int[][] core, arr;
	
	
	static void perm(int idx, int connected, int wire, int coreCnt, int check) {
		if(idx==coreCnt) {
			if(connectedMax < connected) {
				connectedMax = connected;
				answer = wire;
			}
			else if(connectedMax == connected) {
				answer = Math.min(answer, wire);
			}
			return;
		}
		
		
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		
		// 가장자리 위치하면 무조건 연결
		int ny, nx;
		int cnt;
		// 연결 안 할때
		perm(idx+1, connected, wire, coreCnt, check);
		
		// 연결 할때
		for(int i=0; i<4; i++) {
			ny = core[idx][0];
			nx = core[idx][1];
			cnt = 0;
			while(-1<=ny+dy[i]&&ny+dy[i]<=n && -1<= nx+dx[i]&&nx+dx[i]<=n) {
				ny+=dy[i];
				nx+=dx[i];
				if(ny==-1||nx==-1||ny==n || nx==n) {
					perm(idx+1,connected+1, wire+cnt, coreCnt, check);
					break;
				}
				if(arr[ny][nx]==1||arr[ny][nx]!=0) break;
				arr[ny][nx] = arr[core[idx][0]][core[idx][1]];
				cnt++;
			}
			ny = core[idx][0];
			nx = core[idx][1];
			while(cnt-->0) {
				ny+=dy[i];
				nx+=dx[i];
				arr[ny][nx] = 0;
			}
		}
		
	}
	static void sol() throws Exception{
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int coreCnt = 0, check = 0, connected = 0;
		
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken()); 
				if(arr[i][j]==1) {
					if(i==0||j==0||i==n-1||j==n-1) {
						connected++;
					}
					else {
						core[coreCnt][0] = i;
						core[coreCnt][1] = j;
						coreCnt++;
					}
				}
			}
		}
		
		/*
		 * 외곽은 무조건 연결
		 * 각 프로세서 들의 연결 여부 및 방향 설정
		 */
		answer = Integer.MAX_VALUE; connectedMax = 0;
		perm(0, connected, 0, coreCnt, check);
		
	}
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		core = new int[12][2];
		arr = new int[12][12];
		
		for(int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE; connectedMax = 0; 
			sol();
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);

	}

}