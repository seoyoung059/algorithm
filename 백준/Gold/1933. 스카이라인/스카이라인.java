import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int l;
        int h;
        int r;

        Node(int l, int h, int r) {
            this.l = l;
            this.h = h;
            this.r = r;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "l=" + l +
                    ", h=" + h +
                    ", r=" + r +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if(this.h==o.h) return this.l-o.l;
            return o.h - this.h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n+1];
        StringTokenizer st;
        int l, h, r;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            arr[i] = new Node(l, h, r);
        }
        arr[n] = new Node(1_000_000_001, 1, 1_000_000_002);

        Arrays.sort(arr, (o1, o2)->{
            if(o1.l==o2.l) return o2.h-o1.h;
            return o1.l-o2.l;
        });
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(0, 0, 1_000_000_001));
        StringBuilder sb = new StringBuilder();

        int idx = 0, currH = 0, currX = 0;
        while(idx < n || pq.size() > 1) {
            if (idx < n) {
                while (pq.peek().r < arr[idx].l) {
                    currX = pq.poll().r;
                    while(!pq.isEmpty() && pq.peek().r <= currX){
                        pq.poll();
                    }
                    if(currH > pq.peek().h) {
                        sb.append(currX).append(' ');
                        sb.append(pq.peek().h).append(' ');
                        currH = pq.peek().h;
                    }
                }

                pq.offer(arr[idx++]);
                if(pq.peek().h > currH) {
                    sb.append(pq.peek().l).append(' ');
                    sb.append(pq.peek().h).append(' ');
                    currH = pq.peek().h;
                }
            }

            else {
//                System.out.println("hihi");
                while (pq.size() > 1) {
//                    System.out.println(pq.toString());
                    currX = pq.poll().r;
                    while(!pq.isEmpty() && pq.peek().r <= currX){
                        pq.poll();
                    }
                    if(currH > pq.peek().h) {
                        sb.append(currX).append(' ');
                        sb.append(pq.peek().h).append(' ');
                        currH = pq.peek().h;
                    }
                }
            }
//            System.out.println(sb.toString());
        }


        System.out.println(sb);
    }
}