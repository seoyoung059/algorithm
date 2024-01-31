import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static LinkedList<Edge>[] edgeArray;
    static int answer;

    static class Edge {
        int left;
        int right;
        int weight;
        public Edge(int left, int right, int weight) {
            this.left = left;
            this.right = right;
            this.weight = weight;
        }

        public String toString() {
            return this.left+ " " + this.right+ " : "+this.weight;
        }

    }


    static int dfs(int prev, int current) {
        if(edgeArray[current].size()==1)
            return edgeArray[current].peek().weight;
        int max = 0; Edge currEdge = edgeArray[current].peek();
        int tmp = 0; int next;
        for (Edge e: edgeArray[current]) {
            if (e.left==prev || e.right==prev) {
                currEdge = e;
                continue;
            }
            next = (e.left==current)?e.right:e.left;
            tmp = dfs(current,next);
            answer = Math.max(tmp+max, answer);
            max = Math.max(max, tmp);
        }
        return max + currEdge.weight;
    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        edgeArray = new LinkedList[n+1];
        for (int i = 1; i < n+1; i++) {
            edgeArray[i] = new LinkedList<Edge>();
        }

        int curr, end, weight;
        Edge newEdge;
        Edge rootEdge = new Edge(0,1,0);
        edgeArray[1].offer(rootEdge);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            curr = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            while (end!=-1) {
                weight = Integer.parseInt(st.nextToken());
                if (curr < end) {
                    newEdge = new Edge(curr, end, weight);
                    edgeArray[curr].offer(newEdge);
                    edgeArray[end].offer(newEdge);
                }
                end = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i=1; i<n+1; i++){
//            System.out.println(edgeArray[i].toString());
//        }
        answer = 0;
        dfs(0,1);
        System.out.println(answer);
    }
}