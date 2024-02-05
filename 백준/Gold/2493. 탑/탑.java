import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Stack;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static class Tower {
		int height;
		int idx;
		public Tower(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Tower> stk = new ArrayDeque<Tower>();
		stk.push(new Tower(Integer.MAX_VALUE, 0));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int currHeight;
		for(int i=1; i<=n; i++) {
			currHeight = Integer.parseInt(st.nextToken());
			while(currHeight > stk.peek().height) {
				stk.pop();
			}
			sb.append(stk.peek().idx).append(" ");
			stk.push(new Tower(currHeight, i));
		}
		
		System.out.println(sb);
	}
}