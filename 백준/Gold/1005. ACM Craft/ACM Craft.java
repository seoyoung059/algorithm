import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int n, k, a, b, w;
        int[] d, indegree, answer;
        ArrayDeque[] order;
        ArrayDeque<Integer> zeroIndegree = new ArrayDeque<>();
        for (int tc = 1; tc <= T; tc++) {
            zeroIndegree.clear();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            order = new ArrayDeque[n+1];
            d = new int[n+1];
            indegree = new int[n+1];
            answer = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n+1; i++) {
                d[i] = Integer.parseInt(st.nextToken());
                order[i] = new ArrayDeque<Integer>();
            }


            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                indegree[b]++;
                order[a].offer(b);
            }
            w = Integer.parseInt(br.readLine());

            for (int i = 1; i < n+1; i++) {
                if(indegree[i]==0) {
                    zeroIndegree.offer(i);
                }
            }

            while(!zeroIndegree.isEmpty()){
                a = zeroIndegree.poll();
                answer[a] += d[a];
                if(a==w) break;
                while(!order[a].isEmpty()){
                    b = (int) order[a].poll();
                    indegree[b]--;
                    answer[b] = Math.max(answer[b], answer[a]);
                    if(indegree[b]==0)
                        zeroIndegree.offer(b);
                }
            }
            sb.append(answer[w]).append("\n");
        }
        System.out.println(sb);
    }
}