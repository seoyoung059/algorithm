import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static int[] dy, dx, price;
	static int n;
	
	static boolean isValid(int y, int x) {
		return (0<=y)&&(y<n)&&(0<=x)&&(x<n);
	}
	
	static int distance(int i, int j, int y, int x) {
		return Math.abs(i-y)+Math.abs(j-x);
	}
	
	static int sol() throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> q = new ArrayDeque<>();
	
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) q.offer(new int[] {i, j});
			}
		}
		
		
		
		int[] houseCnt = new int[n*2+1];
		int[] curr;
		int tmp; int max=0;
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tmp = 0;
				for(int h=0; h<q.size(); h++) {
					curr = q.pollFirst();
					houseCnt[distance(i,j,curr[0], curr[1])]++;
					q.offerLast(curr);
				}
				for(int k=0; k<2*n+1; k++) {
					if(houseCnt[k]==0) continue;
					tmp+=houseCnt[k];
					if(m*tmp-price[k]>=0) {
						answer = Math.max(answer, tmp);
					}
					houseCnt[k] = 0;
				}
			}
		}
		return answer;
	}
	public static void main(String args[]) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dy = new int[] {1, -1, 0, 0};
		dx = new int[] {0, 0, 1, -1};
		
		price = new int[20*2+1];
		for(int k=1; k<2*20+2; k++) {
			price[k-1] = k*k+(k-1)*(k-1);
		}
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ").append(sol()).append("\n");
		}
		System.out.print(sb);
	}
}