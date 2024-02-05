import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    static Stack stk;

    static int cal(char c) {
        int tmp = 1;
        char current;
        while (!stk.isEmpty()) {
            if (stk.peek() instanceof Integer) {
                tmp *= (int) stk.pop();
            } else {
                current = ((String) stk.peek()).charAt(0);
                if ((current == '(' && c == ']') || (current == '[' && c == ')')) {
                    return -1;
                } else {
                    stk.pop();
                    if (c == ')') return tmp * 2;
                    else return tmp * 3;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        int tmp = 0;
        int idx = 0;
        char c;
        stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '(' || c == '[')
                stk.push(Character.toString(c));
            else {
                tmp = cal(c);
                if (tmp == -1) {
                    break;
                } else {
                    stk.push(tmp);
                }
            }
            tmp = 0;
            while (!stk.isEmpty() && stk.peek() instanceof Integer) {
                tmp += (int) stk.pop();
            }
            if (tmp != 0) stk.push(tmp);
        }
        if (stk.size() ==1&&stk.peek() instanceof Integer)
            answer = (int) stk.peek();
        else answer=0;
        System.out.println(answer);
    }
}