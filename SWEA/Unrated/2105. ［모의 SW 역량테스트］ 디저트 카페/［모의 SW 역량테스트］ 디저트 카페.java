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
//		System.out.println("move1: "+y+" "+x);
		if(!isValid(y, x) || visited[arr[y][x]]) {
			return;
		}
//		System.out.println("move1: "+y+" "+x);
		visited[arr[y][x]] = true;
		move1(y+1, x+1, cnt+1, visited);
		move2(y+1, x-1, cnt, cnt+1, visited);
		visited[arr[y][x]] = false;
	}
	
	static void move2(int y, int x, int a, int cnt, boolean[]visited) {
		if(!isValid(y, x) || visited[arr[y][x]]) {
			return;
		}

//		System.out.println("move2: "+y+" "+x);
		visited[arr[y][x]] = true;
		move2(y+1, x-1, a, cnt+1, visited);
		move3(y, x, a, cnt-a, cnt+1, visited);
		visited[arr[y][x]] = false;
		
	}

	static void move3(int y, int x, int a, int b, int cnt, boolean[]visited) {
//		System.out.println("move3: a: "+a);
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
//		System.out.println("move3: "+y+" "+x);
		if(!failed) move4(y, x, b, cnt+tmp, visited);
		for(int i=0; i<tmp; i++) {
			visited[arr[y][x]]=false;
			y++; x++;
		}
	}
	
	static void move4(int y, int x, int b, int cnt, boolean[] visited) {
//		System.out.println("move4: b: "+b);

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
//		System.out.println("move4: "+y+" "+x);
		if(!failed) answer = Math.max(answer, cnt+tmp);
		for(int i=0; i<tmp; i++) {
			visited[arr[y][x]]=false;
			y++; x--;
		}
//		System.out.println("answer: "+cnt);
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
		
		/*
		 * 대각선 방향으로 움직이고 사각형을 그리며 출발한 카페로 돌아오기
		 * 지역을 벗어나면 안됨
		 * 같은 숫자의 디저트를 팔고 있는 카페가 나오면 안됨
		 * 하나에서 먹는것도 안됨
		 * 왔던 길을 다시 돌아가는것도 안됨
		 * 
		 * 되도록 많이 먹을 수 있는 경로를 찾고, 그 때의 디저트 수를 구하기
		 * 4<=N<=20
		 * 디저트 종류는 1이상 100이
		 * 
		 * 접근
		 * 백트레킹이지 일단은?
		 * 각 지점을 시작점으로 잡고 우하향 몇번하는지, 우상향 몇번하는지 정하고 가능한지 체크
		 * 둘 다 한번씩은 해야함
		 * 한번 돌 때 arr 만들어서 해야겠다 그럼
		 * 디저트 먹은 수랑 먹었는지는 visited 배열이랑 cnt로 가야할듯
		 * 재귀
		 * 
		 */
		
		answer = -1;
		boolean[] visited = new boolean[101];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				visited[arr[i][j]] = true;
				move1(i+1,j+1,1,visited);
				Arrays.fill(visited, false);
			}
		}
//		System.out.println(answer);
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