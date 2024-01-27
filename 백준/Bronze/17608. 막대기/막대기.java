import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Integer> stk = new Stack<>();

    static void solution(int n) throws IOException {
        int num;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            while(!stk.isEmpty() && stk.peek() <= num){
                stk.pop();
            }
            stk.push(num);
        }
        System.out.println(stk.size());
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        solution(n);
    }
}
