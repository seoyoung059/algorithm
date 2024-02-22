import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static boolean check(int[][] edge, int k) {
		int visited = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		int tmp=0; int curr;
		while((k&(1<<tmp))==0) {
			tmp++;
		}
		q.offer(tmp);
		visited|=(1<<tmp);
		while(!q.isEmpty()) {
			curr = q.poll();
			for(int i=0; i<edge[curr].length; i++) {
				if((k&(1<<edge[curr][i]))!=0 && ((visited&(1<<edge[curr][i]))==0)) {
					q.offer(edge[curr][i]);
					visited|=(1<<edge[curr][i]);
				}
			}
		}
		return visited == k;
	}
	
	static int count(int[] p, int k) {
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans+=((k&(1<<i))>0)?p[i]:0;
		}
		return ans;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] p = new int[n];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			sum += p[i];
		}

		
		
		int tmp;
		int[][] edge = new int[n][];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());
			edge[i] = new int[tmp];
			for(int j=0; j<(edge[i].length); j++) {
				edge[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		
		int answer = Integer.MAX_VALUE;
		for(int i=1; i<(1<<n)-1;i++) {
//			tmp = i;
//			System.out.println(Integer.toBinaryString(i)+" "+ Integer.toBinaryString((1<<n)-1-i));
			if(check(edge,i)&&check(edge, (1<<n)-1-i)) {
				answer = Math.min(answer, Math.abs(sum-2*count(p,i)));
			}
		}
		
		
		System.out.print((answer==Integer.MAX_VALUE)?-1:answer);
		
	}

}