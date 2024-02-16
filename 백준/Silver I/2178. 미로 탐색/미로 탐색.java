import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static boolean isValid(int n, int m, int y, int x) {
		return (0<=y)&&(y<n)&&(0<=x)&&(x<m);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		
		String[] arr = new String[n];
		int[][] visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0});
		visited[0][0] = 1;
		int[] curr; int ny, nx;
		while(!q.isEmpty()) {
			curr = q.poll();
			for(int i=0; i<4; i++) {
				ny = curr[0]+dy[i];
				nx = curr[1]+dx[i];
				if(ny==n-1&&nx==m-1) {
					System.out.print(visited[curr[0]][curr[1]]+1);
					return;
				}
				if(isValid(n, m, ny, nx)&&arr[ny].charAt(nx)=='1'&&visited[ny][nx]==0) {
					visited[ny][nx] = visited[curr[0]][curr[1]]+1;
					q.offer(new int[] {ny, nx});
				}
			}
			
		}
		
		
	}
}