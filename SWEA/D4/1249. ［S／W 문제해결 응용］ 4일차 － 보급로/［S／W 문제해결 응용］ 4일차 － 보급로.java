import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	static BufferedReader br;
	static boolean isValid(int n, int y, int x) {
		return(0<=y)&&(y<n)&&(0<=x)&&(x<n);
	}
	static int solution() throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		String str;
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = (int)(str.charAt(j)-'0');
			}
		}
		
		int[][] visited = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		visited[0][0] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
		
		pq.offer(new int[] {0,0,0});
		
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		int[] curr;int ny, nx;
		while(!pq.isEmpty()) {
			curr = pq.poll();
			for(int i=0; i<4; i++) {
				ny = curr[0]+dy[i];
				nx = curr[1]+dx[i];
				if(isValid(n, ny, nx)&&(visited[ny][nx] > curr[2]+arr[ny][nx])){
					visited[ny][nx] = curr[2]+arr[ny][nx];
					pq.offer(new int[] {ny, nx, visited[ny][nx]});
				}
				if(ny==n-1&&nx==n-1) return visited[n-1][n-1];
			}
		}
			
		return visited[n-1][n-1];	
	}
	
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc<= T; tc++) {
			sb.append("#").append(tc).append(" ").append(solution()).append("\n");
		}
		System.out.print(sb);
	}

}