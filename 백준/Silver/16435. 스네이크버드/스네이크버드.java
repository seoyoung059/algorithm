import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
//		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		while(!pq.isEmpty()) {
			if(pq.peek()<=l) {
				l++;
				pq.poll();
			} else break;
		}
		
		System.out.print(l);
		
		
	}
}