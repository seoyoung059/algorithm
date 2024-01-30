import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] switches;
	
	static void boy(int i) {
		for(int j=0; j<n; j++) {
			if((i-1)+i*j>=n) return;
			switches[(i-1)+i*j] = 1-switches[(i-1)+i*j];
		}
	}
	static void girl(int i) {
		int cnt = 1;
		switches[i] = 1-switches[i];
		int left = i-cnt;
		int right = i+cnt;
		while(left>=0 && right<n) {
			if (switches[left]==switches[right]) {
				switches[left] = 1-switches[left];
				switches[right] = 1-switches[right];
				left--; right++;
			} else break;
		}
	}
	
	static void solution(int deep) throws IOException {
		if(deep==m) return;
		st = new StringTokenizer(br.readLine());
		if(Integer.parseInt(st.nextToken())==1) {
			boy(Integer.parseInt(st.nextToken()));
		} else {
			girl(Integer.parseInt(st.nextToken())-1);
		}
		solution(deep+1);
	}
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		switches = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		
		solution(0);
		for(int i=0; i<n;i++) {
			sb.append(switches[i]);
			if((i+1)%20==0) {
				sb.append("\n");
			} else sb.append(" ");
		}
		System.out.println(sb.toString());
		
	}

}