import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void inorder(char[]arr, int n, int idx) {
        if (idx>n) {
            return;
        }
        inorder(arr, n, idx*2);
        sb.append(arr[idx]);
        inorder(arr, n, idx*2+1);
    }
    static void solution () throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        char[] arr = new char[n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());

                arr[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);

        }
        inorder(arr, n, 1);
    }
    public static void main(String[] args) throws IOException {
        for (int tc = 1; tc <= 10 ; tc++) {
            sb.append("#").append(tc).append(" ");
            solution();
            sb.append("\n");
        }
        System.out.println(sb);
    }
}