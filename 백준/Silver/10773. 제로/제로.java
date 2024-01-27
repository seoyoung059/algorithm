import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void solution(int n) throws IOException {
        Stack<Integer> stk = new Stack<>();
        int curr;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            curr = Integer.parseInt(st.nextToken());

            if(curr==0&&stk.size()>0) stk.pop();
            else stk.push(curr);
        }

        int answer = 0;
        while(!stk.isEmpty()){
            answer+=stk.pop();
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        solution(n);
    }
}
