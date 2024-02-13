import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> courseList = new PriorityQueue<>(Comparator.comparingInt(o->o[0]));
        PriorityQueue<int[]> endList = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            courseList.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int answer = 0;
        int[] curr;
        while(!courseList.isEmpty()){
            curr = courseList.poll();
            if(endList.isEmpty() || endList.peek()[1]>curr[0]){
                answer++;
                endList.offer(curr);
            }
            else {
                endList.poll();
                endList.offer(curr);
            }
        }
        System.out.println(answer);
    }
}