import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int val;
        int idx;
        public Point (int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        ArrayDeque<Point> stk = new ArrayDeque<>();
//        Stack<Point> stk = new Stack<>();
        int curr; Point tmp;
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
            curr = Integer.parseInt(st.nextToken());
            while(!stk.isEmpty() && stk.peek().val < curr){
                tmp = stk.pop();
                arr[tmp.idx] = curr;
            }
            stk.push(new Point(curr,i));
        }

        for (int i: arr){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}