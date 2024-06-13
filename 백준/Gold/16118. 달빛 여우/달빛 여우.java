import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static class Node implements Comparable {
        int point;
        int d;
        int run;

        Node(int point, int d, int run) {
            this.point = point;
            this.d = d;
            this.run = run;
        }

        @Override
        public int compareTo(Object o) {
            return this.d - ((Node) o).d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a, b, d;
        ArrayDeque<Node>[] arr = new ArrayDeque[n + 1];
        int[] fox = new int[n + 1];
        int[][] wolf = new int[2][n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayDeque<>();
            fox[i] = 999_999_999;
            wolf[0][i] = 999_999_999;
            wolf[1][i] = 999_999_999;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken())*2;
            arr[a].offer(new Node(b, d, 0));
            arr[b].offer(new Node(a, d, 0));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));

        Node curr;
        while (!pq.isEmpty()) {
            curr = pq.poll();
            if(fox[curr.point] <= curr.d) continue;

            fox[curr.point] = curr.d;
            for(Node next: arr[curr.point]) {
                if(fox[next.point] > curr.d+next.d)
                    pq.offer(new Node(next.point, curr.d+next.d, 0));
            }
        }

        pq.offer(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            curr = pq.poll();

            if(wolf[curr.run][curr.point] <= curr.d) continue;

            wolf[curr.run][curr.point] = curr.d;

            for(Node next: arr[curr.point]){
                if(curr.run==0 && wolf[1][next.point] > curr.d+next.d/2){
                    pq.offer(new Node(next.point, curr.d+next.d/2, 1));
                } else if(curr.run==1 && wolf[0][next.point] > curr.d+next.d*2) {
                    pq.offer(new Node(next.point, curr.d+next.d*2, 0));
                }
            }

        }


        int answer = 0;
        for (int i = 2; i < n + 1; i++) {
            if (fox[i] < Math.min(wolf[0][i], wolf[1][i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}