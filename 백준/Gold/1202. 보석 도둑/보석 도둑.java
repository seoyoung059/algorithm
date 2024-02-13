import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
// 0213 0926 - 0954
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            if(o1[1]==o2[1]) return o1[0]-o2[0];
            return o2[1]-o1[1];
        });

        int[][] arr = new int[n][2];
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }
//        Arrays.sort();
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(bags);

        long answer = 0L;
        int idx = 0; int[] tmp;
        for (int i = 0; i < k; i++) {
            while(idx<n && arr[idx][0] <= bags[i]){
                pq.offer(arr[idx]);
                idx++;
            }
            if(!pq.isEmpty()) {
                tmp = pq.poll();
                answer += tmp[1];
            }
        }
        System.out.println(answer);
    }
}