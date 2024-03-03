import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static int[] dy, dx;
	static int[][] arr;
	static int n, answer;
	
	
	static boolean isValid(int y, int x) {
		return (0<=y)&&(y<n)&&(0<=x)&&(x<n);
	}
	static void move1(int y, int x, int cnt, boolean[] visited) {
		if(!isValid(y, x) || visited[arr[y][x]]) {
			return;
		}
		visited[arr[y][x]] = true;
		move1(y+1, x+1, cnt+1, visited);
		move2(y+1, x-1, cnt, cnt+1, visited);
		visited[arr[y][x]] = false;
	}
	
	static void move2(int y, int x, int a, int cnt, boolean[]visited) {
		if(!isValid(y, x) || visited[arr[y][x]]) {
			return;
		}

		visited[arr[y][x]] = true;
		move2(y+1, x-1, a, cnt+1, visited);
		move3(y, x, a, cnt-a, cnt+1, visited);
		visited[arr[y][x]] = false;
		
	}

	static void move3(int y, int x, int a, int b, int cnt, boolean[]visited) {
		int tmp = 0; boolean failed = false;
		for(int i=0; i<a; i++) {
			if(!isValid(y-1, x-1) || visited[arr[y-1][x-1]])  {
				failed = true;
				break;
			}
			y--;x--;
			visited[arr[y][x]] = true;
			tmp++;
		}
		if(!failed) move4(y, x, b, cnt+tmp, visited);
		for(int i=0; i<tmp; i++) {
			visited[arr[y][x]]=false;
			y++; x++;
		}
	}
	
	static void move4(int y, int x, int b, int cnt, boolean[] visited) {

		int tmp = 0; boolean failed = false;
		for(int i=0; i<b-1; i++) {
			if(!isValid(y-1, x+1) || visited[arr[y-1][x+1]]) {
				failed = true;
				break;
			}
			y--; x++;
			visited[arr[y][x]] = true;
			tmp++;
		}
		if(!failed) answer = Math.max(answer, cnt+tmp);
		for(int i=0; i<tmp; i++) {
			visited[arr[y][x]]=false;
			y++; x--;
		}
	}
	static void sol() throws Exception{
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = -1;
		boolean[] visited = new boolean[101];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				visited[arr[i][j]] = true;
				move1(i+1,j+1,1,visited);
				Arrays.fill(visited, false);
			}
		}
	}
	public static void main(String args[]) throws Exception{
		StringBuilder sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		dy = new int[] {1,1, -1, -1};
		dx = new int[] {1, -1, 1, -1};
		for(int tc = 1; tc<=T; tc++) {
			sol();
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	

}