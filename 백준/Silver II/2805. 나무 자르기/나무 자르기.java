import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 175252KB	796ms
 */
public class Main {
	static int[] trees;
	static int n;
	static int m;
	static boolean cutTree(int height) {
		long tmp = 0;
		for(int i=n-1; i>=0; i--) {
			if(trees[i] <= height) break;
			tmp+=Math.max(0,trees[i]-height);
			if(tmp >= m) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		trees = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		int start = 0; int end = trees[n-1]; int mid = (start+end)/2;
		while(start<end) {
			mid = (start+end)/2;
			if(cutTree(mid)) {
				start = mid+1;
			} else {
				end = mid;
			}
		}
		System.out.println(end-1);
	}

}