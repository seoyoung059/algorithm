import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n];
        int idx = 0; int tmp; int[] tmparr;
        PriorityQueue<int[]> minpq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(o->o[1])));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "I":
                    tmp = Integer.parseInt(st.nextToken());
                    tmparr = new int[] {idx, tmp};
                    minpq.offer(tmparr);
                    maxpq.offer(tmparr);
                    arr[idx] = true;
                    idx++;
                    break;
                case "D":
                    // 최댓값 삭제
                    if(Integer.parseInt(st.nextToken())==1){
                        while(!maxpq.isEmpty() && !arr[maxpq.peek()[0]]){
                            maxpq.poll();
                        }
                        if(!maxpq.isEmpty()){
                            tmparr = maxpq.poll();
                            arr[tmparr[0]] = false;
                        }
                    }
                    // 최솟값 삭제
                    else {
                        while(!minpq.isEmpty() && !arr[minpq.peek()[0]]){
                            minpq.poll();
                        }
                        if(!minpq.isEmpty()){
                            tmparr = minpq.poll();
                            arr[tmparr[0]] = false;
                        }
                    }
                    break;
            }
        }

        while(!maxpq.isEmpty() && !arr[maxpq.peek()[0]]){
            maxpq.poll();
        }
        if(!maxpq.isEmpty()){
            tmparr = maxpq.poll();
            sb.append(tmparr[1]).append(" ");
        }
        else{
            sb.append("EMPTY").append("\n");
            return;
        }

        while(!minpq.isEmpty() && !arr[minpq.peek()[0]]){
            minpq.poll();
        }
        if(!minpq.isEmpty()){
            tmparr = minpq.poll();
            sb.append(tmparr[1]).append("\n");
        }

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n;
        for (int tc = 1; tc <= T; tc++) {
            solution();
        }
        System.out.print(sb);
    }
}