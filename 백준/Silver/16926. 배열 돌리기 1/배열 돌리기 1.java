import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;

	static void sol2(int n, int m, int r) {
		int tmp;
		int minLen = (n<m)? n:m;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int size=0; size<minLen/2; size++) {
			for(int i=size; i < m-size-1; i++) 
				dq.addLast(arr[size][i]);
			for(int i=size; i<n-size-1; i++) 
				dq.addLast(arr[i][m-1-size]);
			for(int i=m-size-1; i>size; i--) 
				dq.addLast(arr[n-1-size][i]);
			for(int i=n-1-size; i>size; i--) 
				dq.addLast(arr[i][size]);
			

			for(int i=0; i<r; i++) {
				dq.addLast(dq.pollFirst());
			}
			

			for(int i=size; i < m-size-1; i++) 
				arr[size][i] = dq.pollFirst();
			for(int i=size; i<n-size-1; i++) 
				arr[i][m-1-size] = dq.pollFirst();
			for(int i=m-size-1; i>size; i--) 
				arr[n-1-size][i] = dq.pollFirst();
			for(int i=n-1-size; i>size; i--) 
				arr[i][size] = dq.pollFirst();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sol2(n,m,r);
		for(int[] a: arr) {
			for(int i: a) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}