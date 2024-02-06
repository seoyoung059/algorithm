import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] arr = new boolean[n+1];
			StringTokenizer st;
			int idx;
		
			String val;
			int answer = 1;
			for(int i=1; i<n+1; i++){
                if(answer==0){
                    br.readLine();
                    continue;
                }                   
                st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				val = st.nextToken();
				if(i>1&&arr[i/2]) {
					answer = 0;
                    continue;
				}
				if(!"+-/*".contains(val)) {
					arr[i] = true;
				} else {
					arr[i] = false;
					
				}
			}
//			int answer = 1;
//			for(int i=1; i<n+1; i++) {
//				// 숫자면 자식 노드가 없어야함 -> n < 2*i+1
//				if(arr[i]) {
//					if (n>=2*i+1) {
//						answer = 0;
//						break;
//					}
//						
//				} else {
//					// 부호면 자식 노드가 둘다 있어야함 -> 2*i+1 < n
//					if(2*i+1>=n) {
//						answer = 0;
//						break;
//					}
//				}
//			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
        System.out.println(sb);
		
	
	}

}