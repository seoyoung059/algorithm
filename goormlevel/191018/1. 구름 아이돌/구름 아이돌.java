import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		int first = 0, second = 0, third = 0;
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > arr[first]) {
				third = second;
				second = first;
				first = i;
			} else if(arr[i] > arr[second]) {
				third = second;
				second = i;
			} else if(arr[i] > arr[third]){
				third = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(first).append(' ').append(second).append(' ').append(third);
		System.out.println(sb);
	}
}