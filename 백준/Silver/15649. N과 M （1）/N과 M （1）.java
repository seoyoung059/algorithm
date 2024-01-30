import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] isSelected;
	static Stack<Integer> stk = new Stack<>();
	
	static void solution(int num) {
		if (num==m) {
			for(Object o: stk.toArray()) {
				sb.append((int) o);
				sb.append(" ");
			}
			sb.append("\n");
		}
		else {
			for(int i=0; i<n; i++) {
				if(!isSelected[i]) {
					isSelected[i] = true;
					stk.push(i+1);
					solution(num+1);
					stk.pop();
					isSelected[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[n];
		solution(0);
		System.out.println(sb.toString());
	}
}