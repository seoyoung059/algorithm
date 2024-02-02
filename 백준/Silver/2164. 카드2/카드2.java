import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1; i<=n ;i++) {
			q.offer(i);
		}
		
		int i = 0;
		while(q.size()>1) {
			if(i%2==0) {
				q.poll();
			} else {
				q.offer(q.poll());
			}
			i++;
		}
		System.out.println(q.peek());
	}

}