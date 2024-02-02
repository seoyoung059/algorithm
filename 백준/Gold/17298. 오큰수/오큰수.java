import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;
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
        Stack<Point> stk = new Stack<>();
        int curr; Point tmp;
        for (int i = 0; i < n; i++) {
            curr = Integer.parseInt(st.nextToken());
            while(!stk.isEmpty()){
                if (stk.peek().val < curr){
                    tmp = stk.pop();
                    arr[tmp.idx] = curr;
                }
                else break;
            }
            stk.push(new Point(curr,i));
        }
        while(!stk.isEmpty()){
            tmp = stk.pop();
            arr[tmp.idx]=-1;
        }

        for (int i: arr){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}