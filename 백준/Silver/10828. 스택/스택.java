import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static class Stack {

        int[] stk = new int[100_000];
        int size = 0;

        void push(int n){
            this.stk[this.size++] = n;
        }

        void pop() {
            if(this.size==0)
                sb.append(-1);
            else
                sb.append(this.stk[--this.size]);
            sb.append("\n");
        }

        void size(){
            sb.append(this.size);
            sb.append("\n");
        }

        void empty() {
            if (this.size==0)
                sb.append(1);
            else
                sb.append(0);
            sb.append("\n");
        }

        void top() {
            if(this.size==0)
                sb.append(-1);
            else
                sb.append(this.stk[size-1]);
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack stk = new Stack();

        int n = Integer.parseInt(st.nextToken());
        String order; int num;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            switch (order){
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    stk.push(num);
                    break;
                case "pop":
                    stk.pop();
                    break;
                case "size":
                    stk.size();
                    break;
                case "empty":
                    stk.empty();
                    break;
                case "top":
                    stk.top();
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
