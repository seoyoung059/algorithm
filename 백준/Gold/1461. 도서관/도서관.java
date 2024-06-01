import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        
        st = new StringTokenizer(br.readLine());
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if(tmp > 0) positive.offer(tmp);
            else negative.offer(tmp);
        }

        int answer = 0;
        int max = -1;
        // neg, 먼것부터
        int cnt = 0;
        while(!negative.isEmpty()){
            tmp = negative.poll();
            if(cnt==0){
                answer += Math.abs(tmp);
                max = Math.max(max, -tmp);
            }
            cnt++;
            if(cnt==m){
                cnt = 0;
            }
        }

        cnt = 0;
        while(!positive.isEmpty()){
            tmp = positive.poll();
            if(cnt==0){
                answer += Math.abs(tmp);
                max = Math.max(max, tmp);
            }
            cnt++;
            if(cnt==m){
                cnt = 0;
            }
        }
        System.out.println(answer*2-max);
    }
}