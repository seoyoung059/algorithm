import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static class Edge implements Comparable{
        int left;
        int right;
        int weight;

        Edge(int l, int r, int w){
            this.left = l;
            this.right = r;
            this.weight = w;
        }

        @Override
        public int compareTo(Object o) {
            return this.weight - ((Edge)o).weight;
        }
    }

    static int find(int[] p, int a){
        if(p[a] == -1) return a;
        return find(p, p[a]);
    }
    static boolean union(int[] p, int a, int b) {
        int tmp = find(p, a);
        int tmp2 = find(p, b);
        if(tmp==tmp2) return false;
        if(tmp<tmp2) p[tmp2] = tmp;
        else p[tmp] = tmp2;
        return true;
    }
    static long sol() throws Exception {
        int v, e, a, b, w;
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[e];
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a,b,w);
        }
        Arrays.sort(edges);

        int[] p = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            p[i] = -1;
        }

        int cnt = 0; long answer = 0;
        for (int i = 0; i < e; i++) {
            if(cnt >= v-1) break;
            if(union(p, edges[i].left, edges[i].right)){
                cnt++;
                answer+=edges[i].weight;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ").append(sol()).append("\n");
        }
        System.out.print(sb);
    }

}