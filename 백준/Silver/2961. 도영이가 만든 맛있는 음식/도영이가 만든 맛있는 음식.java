import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		int a, b;
		for(int i=1; i<(1<<n); i++) {
			a=1; b=0;
			for(int j=0; j<n; j++) {
				if((i&(1<<j))!=0) {
					a*=arr[j][0];
					b+=arr[j][1];
				}
			}
			answer = Math.min(answer, Math.abs(a-b));
		}
		System.out.println(answer);
	}

}