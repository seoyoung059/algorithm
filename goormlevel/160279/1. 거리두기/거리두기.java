import java.io.*;
class Main {
	static final int mod = 100_000_007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n+1][5];
		arr[0][0] = 1;
		
		for(int i=1; i<=n; i++){
			arr[i][0] = (arr[i-1][0]+arr[i-1][1]+arr[i-1][2]+arr[i-1][3]+arr[i-1][4])%mod;
			arr[i][1] = (arr[i-1][0]+arr[i-1][2]+arr[i-1][3])%mod;
			arr[i][2] = (arr[i-1][0]+arr[i-1][1]+arr[i-1][3]+arr[i-1][4])%mod;
			arr[i][3] = (arr[i-1][0]+arr[i-1][1]+arr[i-1][2])%mod;
			arr[i][4] = (arr[i-1][0]+arr[i-1][2])%mod;
		}
		
		System.out.println((arr[n][0]+arr[n][1]+arr[n][2]+arr[n][3]+arr[n][4])%mod);
		
		
	}
}