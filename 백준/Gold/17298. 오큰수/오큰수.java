import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty()){
                if (stk.peek() > arr[0][i]) break;
                stk.pop();
            }
            if (!stk.isEmpty())
                arr[1][i] = stk.peek();
            else arr[1][i]=-1;
            stk.push(arr[0][i]);
        }
//
//        System.out.println(Arrays.toString(arr[1]));
        for(int i: arr[1])
            sb.append(i).append(" ");
        System.out.println(sb.toString());
    }
}