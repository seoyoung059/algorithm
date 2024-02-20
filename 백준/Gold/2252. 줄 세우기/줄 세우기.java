import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] indegree = new int[n+1];
//        int[] answer = new int[n];
        ArrayDeque<Integer>[] graph = new ArrayDeque[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayDeque<Integer>();
        }
        ArrayDeque<Integer> zeroIndegree = new ArrayDeque<>();

        int a, b;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b= Integer.parseInt(st.nextToken());
            graph[a].offer(b);
            indegree[b]++;
        }

        int idx = 0; int tmp, next;
        for (int i = 1; i < n+1; i++) {
            if(indegree[i]==0){
                zeroIndegree.offer(i);
            }
        }

        while(!zeroIndegree.isEmpty()){
            tmp = zeroIndegree.pollFirst();
//            System.out.println(tmp);
//            System.out.println(zeroIndegree.toString());
//            answer[idx++] = tmp;
            sb.append(tmp).append(" ");
            while(!graph[tmp].isEmpty()){
                next = graph[tmp].poll();
                indegree[next]--;
                if(indegree[next]==0){
                    zeroIndegree.offerLast(next);
                }
            }
        }
        System.out.println(sb);
    }

}