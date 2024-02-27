import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		
		int[] dp = new int[n+3];
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3; i<n+1; i++) {
			dp[i] = (dp[i-1]+dp[i-2]*2)%10007;
		}
		System.out.print(dp[n]);
	}

}