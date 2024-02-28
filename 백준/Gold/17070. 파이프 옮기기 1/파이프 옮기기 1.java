import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n+1][n+1];
		long[][][] dp = new long[n+1][n+1][3];

		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dp[1][1][0] = 1L;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==1&&j==1) continue;
				
				dp[i][j][0] = (j==n||arr[i][j+1]==1)?0: dp[i][j-1][0]+dp[i-1][j-1][1];
				dp[i][j][1] = (i==n||j==n||arr[i+1][j+1]==1||arr[i][j+1]==1||arr[i+1][j]==1)? 0:dp[i][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j][2];
				dp[i][j][2] = (i==n||arr[i+1][j]==1)?0:dp[i-1][j-1][1]+dp[i-1][j][2];
			}
		}
		System.out.println(dp[n][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n][2]);
	}

}