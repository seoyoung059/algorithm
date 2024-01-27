import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Character> stk;
    static StringBuilder sb= new StringBuilder();

    static void solution(int n) throws IOException {
        String curr;
        a: for (int i = 0; i < n; i++) {
            stk = new Stack<>();
            curr = br.readLine();
            for (int j = 0; j < curr.length(); j++) {
                if(curr.charAt(j)=='(') stk.push('(');
                else if(!stk.isEmpty()) stk.pop();
                else {
                    sb.append("NO");
                    sb.append("\n");
                    continue a;
                }
            }
            if (stk.isEmpty())
                sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        solution(n);
        System.out.println(sb.toString());
    }
}
