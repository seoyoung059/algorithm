import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static boolean[] isSelected;

	
	static void solution(int j, int num) {
		// m개 모두 뽑았을 때 출력
		if (num==m) {
			for(int i=0; i<n; i++) {
				if(isSelected[i]) {
				sb.append(i+1);
				sb.append(" ");
				}
			}
			sb.append("\n");
		}
		// 모두 뽑지 않았을 때
		else {
			// n개 중 선택되지 않은 것에 대해 선택, 스택에 푸시 후 재귀 수행
			for(int i=j; i<n; i++) {
				if(!isSelected[i]) {
					isSelected[i] = true;
					solution(i+1,num+1);
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
		
		solution(0,0);
		
		System.out.print(sb.toString());
	}
}