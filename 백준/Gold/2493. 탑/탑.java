import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static class Tower {
        int h;
        int idx;
        public Tower(int h, int idx) {
            this.h = h;
            this.idx = idx;
        }
    }
    static Stack<Tower> stk = new Stack<>();

    static void solution(int n) throws IOException {
        st = new StringTokenizer(br.readLine());
        int height; Tower t;
        stk.push(new Tower(100_000_001, 0));
        for (int i = 0; i < n; i++) {
            height = Integer.parseInt(st.nextToken());
            while(stk.peek().h < height){
                stk.pop();
            }
            sb.append(stk.peek().idx);
            sb.append(" ");
            stk.push(new Tower(height, i+1));
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        solution(n);
        System.out.println(sb.toString());
    }
}
