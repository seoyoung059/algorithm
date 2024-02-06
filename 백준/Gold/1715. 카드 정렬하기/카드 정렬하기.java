import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            br.readLine();
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer=0;
        int tmp;
        while(pq.size()>1) {
            tmp = pq.poll()+pq.poll();
            answer+=tmp;
            pq.offer(tmp);
        }
        System.out.println(answer);

    }
}