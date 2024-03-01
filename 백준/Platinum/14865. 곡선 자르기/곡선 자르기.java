import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    static class P implements Comparable {
        int s;
        int e;

        P(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Object o) {
            return this.s - ((P) o).s;
        }

        @Override
        public String toString() {
            return "[" + s + " " + e + "]";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int s = Integer.MIN_VALUE, e = Integer.MIN_VALUE;
        int prevy = 0;
        PriorityQueue<P> pq = new PriorityQueue<>();
        ArrayDeque<int[]> stk = new ArrayDeque<>();

        int y, x = 0;
        int sy = 0, sx = 0;
        int find = 0;
        boolean first = true;
        int firste = 0;
        boolean finde = false, finds = false, a = false;
        for (int i = 0; i < n+1; i++) {
            if(i<n){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                if(first) {
                    sy = y; sx = x;
                    first = false;
                }
            }
            else {
                y = sy; x = sx;
            }
            if (prevy < 0 && y > 0) {
//                System.out.println("up: "+x);
                stk.offerLast(new int[] {x, +1});
            } else if (prevy > 0 && y < 0) {
//                System.out.println("down: "+x);
                if(!stk.isEmpty()){
//                    System.out.println(stk.peekLast()[0]+" "+ x);
                    if(stk.peekLast()[0]<x){
                        pq.offer(new P(stk.pollLast()[0], x));
                    }
                    else {
                        pq.offer(new P(x, stk.pollLast()[0]));
                    }
                }
                else {
                    stk.offer(new int[] {x, -1});
                }
            }
            prevy = y;
        }
        if (!stk.isEmpty()) {
            int[] p1 = stk.poll();
            int[] p2 = stk.poll();
            if(p1[0]<p2[0]) pq.offer(new P(p1[0], p2[0]));
            else pq.offer(new P(p2[0], p1[0]));
        }


        P curr, prev;
        int cnt1 = 0;
        int cnt2 = 0;
        ArrayDeque<P> stack = new ArrayDeque<>();
//        System.out.println(pq);
        while (!pq.isEmpty()) {
            curr = pq.poll();
            /*
               현재 s보다 e가 작은건 다 빼고
               스택이 비면 제일 바깥거
                내거 다음거의 s가 내 end보다 크면 나는 제일 안쪽거
             */
            while (!stack.isEmpty() && stack.peekLast().e < curr.s) {
                stack.pollLast();
            }
            if (stack.isEmpty()) cnt1++;
            if (pq.isEmpty() || pq.peek().s > curr.e) cnt2++;
            stack.offerLast(curr);
        }
        System.out.println(cnt1 + " " + cnt2);
    }
}

/*

14
0 -4
-4 -4
-4 3
3 3
3 -2
1 -2
1 1
-1 1
-1 -1
-2 -1
-2 2
-3 2
-3 -2
0 -2
0 -4
-4 -4
-4 3


[[-4 3], [-1 1], [-3 -2]]
1 2
 */