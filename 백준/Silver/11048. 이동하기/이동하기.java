import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] dp;
	static BufferedReader br;
	static StringTokenizer st;
	
	static int sol(int[][] arr, int y, int x) {
		if(!(0<=y && y<n && 0<=x &&x<m)) return 0;
		if(dp[y][x]!=-1) return dp[y][x];
		dp[y][x]  =  Math.max(sol(arr, y-1, x), Math.max(sol(arr, y, x-1), sol(arr, y-1, x-1)))+arr[y][x];
		return dp[y][x];
	}
	
	static void sol2() throws Exception{
		int[][] arr = new int[n][m];
		dp = new int[n][m];

		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.print(sol(arr, n-1, m-1));
		
	}

	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m  = Integer.parseInt(st.nextToken());
		

		sol2();
	}

}