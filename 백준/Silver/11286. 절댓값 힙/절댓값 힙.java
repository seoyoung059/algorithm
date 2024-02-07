import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
			int tmp = Math.abs(o1)-Math.abs(o2);
			if(tmp==0) {
				return o1-o2;
			}
			return tmp;
		});
		int n = Integer.parseInt(br.readLine());
		int tmp;
		for(int i=0; i<n; i++) {
			tmp = Integer.parseInt(br.readLine());
			if(tmp==0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else 
					sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(tmp);
				
			}
		}
		System.out.print(sb);
	}

}